package test;

import entity.Bot;
import entity.Player;
import entity.StateDoesNotAllowActionException;
import entity.Virologist;
import game.*;
import inventory.*;
import item.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Tesztesetek oszt�lya
 */
public class TestCases {

    /**
     * Kulcs kikeresése objektum szerint
     */
    private static String getKeyByObj(Object o) {
        for (String s : SkeletonTesterMenu.objects.keySet())
            if (SkeletonTesterMenu.objects.get(s).equals(o))
                return s;
        return null;
    }

    /**
     * Véletlenszerű mező generálása
     */
    private static Tile getTile(int n) {
        if (n == 0)
            n = new Random().nextInt(5) + 1;
        Tile t;
        switch (n) {
            case 1:
                t = new Town();
                break;
            case 2:
                t = new BearLaboratory();
                break;
            case 3:
                t = new SafeLaboratory();
                break;
            case 4:
                t = new Storage();
                break;
            default:
                t = new Safehouse();
                break;
        }
        return t;
    }

    /**
     * Véletlenszerű ágens generálása
     */
    private static Agent getAgent(int n) {
        if (n == 0)
            n = new Random().nextInt(5) + 1;
        Agent a;
        switch (n) {
            case 1:
                a = new Forgetter();
                break;
            case 2:
                a = new Dancer();
                break;
            case 3:
                a = new Paralyzer();
                break;
            case 4:
                a = new Protector();
                break;
            default:
                a = new Bear();
                break;
        }
        return a;
    }

    /**
     * V�letlenszerű recept generálása
     */
    private static Recipe getRecipe(int n) {
        if (n == 0)
            n = new Random().nextInt(4) + 1;
        Recipe r;
        switch (n) {
            case 1:
                r = new RForgetter();
                break;
            case 2:
                r = new RDancer();
                break;
            case 3:
                r = new RParalyzer();
                break;
            default:
                r = new RProtector();
                break;
        }
        return r;
    }

    /**
     * Véletlenszerű felszerelés generálása
     */
    private static Gear getGear(int n) {
        if (n == 0)
            n = new Random().nextInt(4) + 1;
        Gear g;
        switch (n) {
            case 1:
                g = new Bag();
                break;
            case 2:
                g = new Glove();
                break;
            case 3:
                g = new Jacket();
                break;
            default:
                g = new Axe();
                break;
        }
        return g;
    }

    /**
     * Véletlenszerű anyag generálása
     */
    private static Material getMaterial(int n) {
        if (n == 0)
            n = new Random().nextInt(2) + 1;
        Material m;

        if (n == 1) {
            m = new Aminoacid();
        } else {
            m = new Nucleoid();
        }

        return m;
    }

    /**
     * Véletlenszerű virológus generálása
     */
    private static Virologist getVirologist(int n) {
        if (n == 0)
            n = new Random().nextInt(2) + 1;
        Virologist v;

        if (n == 1) {
            v = new Player();
        } else {
            v = new Bot();
        }

        return v;
    }

    /**
     * Új játék létrehozása
     * alapértelmezetten a tileid az "tile"+szám, hogy éppen melyik mezot generalta le, pl tile5 az a 6. tile
     */
    public static void newGame() {
        int tileCount = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[1]);
        Game.newGame();
        for (int i = 0; i < tileCount; i++) {
            Tile t = getTile(0);
            Game.map.addTile(t);
            SkeletonTesterMenu.objects.put("t" + i, t);
        }
    }

    /**
     * Játék vége
     */
    public static void endGame() {
        Game.map = null;
        SkeletonTesterMenu.objects.clear();
    }

    /**
     * Mező létrehozása
     */
    public static void createTile() {
        String tileId = SkeletonTesterMenu.cmd.split(" ")[1];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[2]);

        Tile t = getTile(type);
        Game.map.addTile(t);
        SkeletonTesterMenu.objects.put(tileId, t);
    }

    /**
     * Ágens létrehozása
     */
    public static void createAgent() throws NotEnoughSpaceException {
        String ageId = SkeletonTesterMenu.cmd.split(" ")[1];
        String virId = SkeletonTesterMenu.cmd.split(" ")[2];

        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[3]);
        int life = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[4]);

        Agent a = getAgent(type);
        SkeletonTesterMenu.objects.put(ageId, a);

        IInventoryHolder h = (IInventoryHolder) SkeletonTesterMenu.objects.get(virId);
        h.getInventory().addItem(a);
    }

    /**
     * Recept létrehozása
     */
    public static void createRecipe() throws NotEnoughSpaceException {
        String recId = SkeletonTesterMenu.cmd.split(" ")[1];
        String virId = SkeletonTesterMenu.cmd.split(" ")[2];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[3]);

        Recipe r = getRecipe(type);
        IInventoryHolder h = (IInventoryHolder) SkeletonTesterMenu.objects.get(virId);
        h.getInventory().addItem(r);
        SkeletonTesterMenu.objects.put(recId, r);
    }

    /**
     * Felszerelés létrehozása
     */
    public static void createGear() throws NotEnoughSpaceException {
        String grId = SkeletonTesterMenu.cmd.split(" ")[1];
        String virId = SkeletonTesterMenu.cmd.split(" ")[2];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[3]);

        Gear g = getGear(type);
        IInventoryHolder h = (IInventoryHolder) SkeletonTesterMenu.objects.get(virId);
        h.getInventory().addItem(g);
        SkeletonTesterMenu.objects.put(grId, g);
    }

    /**
     * Felszerelés létrehozása
     */
    public static void createMaterial() throws NotEnoughSpaceException {
        String matId = SkeletonTesterMenu.cmd.split(" ")[1];
        String virId = SkeletonTesterMenu.cmd.split(" ")[2];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[3]);

        Material m = getMaterial(type);
        IInventoryHolder h = (IInventoryHolder) SkeletonTesterMenu.objects.get(virId);
        h.getInventory().addItem(m);
        SkeletonTesterMenu.objects.put(matId, m);
    }

    /**
     * Virológus létrehozása
     */
    public static void createVirologist() {
        String virId = SkeletonTesterMenu.cmd.split(" ")[1];
        String tileId = SkeletonTesterMenu.cmd.split(" ")[2];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[3]);

        Virologist v = getVirologist(type);
        Tile t = (Tile) SkeletonTesterMenu.objects.get(tileId);
        t.addVirologist(v);
        SkeletonTesterMenu.objects.put(virId, v);
    }

    /**
     * Két szomszédos mező hozzáadása
     */
    public static void addNeighbour() {
        String tile1 = SkeletonTesterMenu.cmd.split(" ")[1];
        String tile2 = SkeletonTesterMenu.cmd.split(" ")[2];

        Tile t1 = (Tile) SkeletonTesterMenu.objects.get(tile1);
        Tile t2 = (Tile) SkeletonTesterMenu.objects.get(tile2);

        t1.addNeighbour(t2);
        t2.addNeighbour(t1);
    }

    /**
     * Játékállás mentése
     *
     * @throws IOException
     */
    public static void saveGame() throws IOException {
        String fileName = SkeletonTesterMenu.cmd.split(" ")[1];

        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(SkeletonTesterMenu.objects);
        out.close();
        file.close();
    }

    /**
     * Játék betöltése
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void loadGame() throws IOException, ClassNotFoundException {
        String fileName = SkeletonTesterMenu.cmd.split(" ")[1];

        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);


        SkeletonTesterMenu.objects = (HashMap<String, Object>) in.readObject();


        in.close();
        file.close();
    }

    /**
     * Mezők kilistázása
     */
    public static void listTiles() {
        try {
            for (String key : SkeletonTesterMenu.objects.keySet())
                System.out.println(getKeyByObj((Tile) SkeletonTesterMenu.objects.get(key)));
        } catch (Exception ignore) {

        }
    }

    /**
     * Szomszédok kilistázása
     */
    public static void listNeighbours() {
        String tileId = SkeletonTesterMenu.cmd.split(" ")[1];
        Tile t = (Tile) SkeletonTesterMenu.objects.get(tileId);

        for (Tile n : t.getNeighbours())
            System.out.println(getKeyByObj(n));

    }

    /**
     * Virológusok kilistázása
     */
    public static void listVirologist() {
        String tileId = SkeletonTesterMenu.cmd.split(" ")[1];
        Tile t = (Tile) SkeletonTesterMenu.objects.get(tileId);

        for (Virologist v : t.getVirologist())
            System.out.println(getKeyByObj(v));
    }

    /**
     * Inventory kilistázása
     */
    public static void listInventory() {
        String virId = SkeletonTesterMenu.cmd.split(" ")[1];
        IInventoryHolder h = (IInventoryHolder) SkeletonTesterMenu.objects.get(virId);
        Inventory i = h.getInventory();

        i.reset();
        while (i.hasNext())
            System.out.println(getKeyByObj(i.next()));
    }

    /**
     * Felkent ágensek listázása
     */
    public static void listApplied() {
        String vir1 = SkeletonTesterMenu.cmd.split(" ")[1];

        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(vir1);
        for (Agent a : v.getApplied())
            System.out.println(getKeyByObj(a));
    }

    /**
     * Ágens használata
     * @throws StateDoesNotAllowActionException
     */
    public static void useAgent() throws ItemNotFoundException, StateDoesNotAllowActionException {
        String age1 = SkeletonTesterMenu.cmd.split(" ")[1];
        String vir1 = SkeletonTesterMenu.cmd.split(" ")[2];
        String vir2 = SkeletonTesterMenu.cmd.split(" ")[3];

        Agent a = (Agent) SkeletonTesterMenu.objects.get(age1);
        Virologist v1 = (Virologist) SkeletonTesterMenu.objects.get(vir1);
        Virologist v2 = (Virologist) SkeletonTesterMenu.objects.get(vir2);

        v1.useAgent(v2, a);
    }

    /**
     * Felszerelés használata
     * @throws StateDoesNotAllowActionException
     */
    public static void useGear() throws StateDoesNotAllowActionException {
        String gear = SkeletonTesterMenu.cmd.split(" ")[1];
        String vir1 = SkeletonTesterMenu.cmd.split(" ")[2];
        String vir2 = SkeletonTesterMenu.cmd.split(" ")[3];

        Gear g = (Gear) SkeletonTesterMenu.objects.get(gear);
        Virologist v1 = (Virologist) SkeletonTesterMenu.objects.get(vir1);
        Virologist v2 = (Virologist) SkeletonTesterMenu.objects.get(vir2);

        v1.useGear(g, v2);
    }

    /**
     * Ágens létrehozása
     * @throws StateDoesNotAllowActionException
     */
    public static void craftAgent() throws NotEnoughSpaceException, ItemNotFoundException, StateDoesNotAllowActionException {
        String vir = SkeletonTesterMenu.cmd.split(" ")[1];
        String rec = SkeletonTesterMenu.cmd.split(" ")[2];

        Recipe r = (Recipe) SkeletonTesterMenu.objects.get(rec);
        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(vir);

        v.makeAgent(r);
    }

    /**
     * Virológus léptetése
     * @throws StateDoesNotAllowActionException
     */
    public static void move() throws NotEnoughSpaceException, StateDoesNotAllowActionException {
        String virId = SkeletonTesterMenu.cmd.split(" ")[1];
        String tileId = SkeletonTesterMenu.cmd.split(" ")[2];

        Tile t = (Tile) SkeletonTesterMenu.objects.get(tileId);
        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(virId);

        v.move(t,true);
    }

    /**
     * Léptethető dolgok léptetése
     */
    public static void step() throws ItemNotFoundException {
        String id = SkeletonTesterMenu.cmd.split(" ")[1];
        Steppable s = (Steppable) SkeletonTesterMenu.objects.get(id);

        s.step();
    }

    /**
     * Virológus kirablása
     * @throws ItemNotFoundException
     * @throws StateDoesNotAllowActionException
     */
    public static void rob() throws StateDoesNotAllowActionException, ItemNotFoundException {
        String vir1 = SkeletonTesterMenu.cmd.split(" ")[1];
        String vir2 = SkeletonTesterMenu.cmd.split(" ")[2];

        Virologist v1 = (Virologist) SkeletonTesterMenu.objects.get(vir1);
        Virologist v2 = (Virologist) SkeletonTesterMenu.objects.get(vir2);

        v1.robVirologist(v2);
    }

    /**
     * Kabát Determinisztikájának állítása
     */
    public static void setJacket() {
        String gearId = SkeletonTesterMenu.cmd.split(" ")[1];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[2]);
        Jacket j = (Jacket) SkeletonTesterMenu.objects.get(gearId);

        double success;
        switch (type) {
            case 1:
                success = 1;
                break;
            case 2:
                success = 0;
                break;
            default:
                success = 0.823;
                break;
        }

        j.success = success;
    }

    /**
     * Felszerelés eldobása
     *
     * @throws ItemNotFoundException teszt
     */
    public static void throwGear() throws ItemNotFoundException {
        String virId = SkeletonTesterMenu.cmd.split(" ")[1];
        String gearId = SkeletonTesterMenu.cmd.split(" ")[2];

        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(virId);
        v.getInventory().removeItem((Gear) SkeletonTesterMenu.objects.get(gearId));
    }

    /**
     * Virológus meghal
     */
    public static void virologistDie() {
        String virId = SkeletonTesterMenu.cmd.split(" ")[1];
        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(virId);
        
        v.die();
    }
    
    /**
     * Az összes beírható parancsról ad egy rövid tájékoztatást.
     */
    public static void help() {
    	HashMap<String, String> helps = new HashMap<>();
    	String command = SkeletonTesterMenu.cmd.split(" ")[1];
    	
    	helps.put("newGame", "newGame param1: Létrehoz egy új játékot, a játékhoz ad param1 mennyiségű véletlenszerű pályaelemet.");
    	helps.put("endGame", "endGame : Kitörli az eddig létrehozott játékot.");
    	helps.put("createTile", "createTile param1 param2 : Létrehoz egy új mezőt. param1 az új mező azonosítója, param2 a mező típusa.");
    	helps.put("createAgent", "createAgent param1 param2 param3 param4 : Létrehoz egy új ágenst. param1 az új ágens azonosítója, param2  inventoryjába kerül, param3 a típusa, param4 az elbomásig visszamaradt idő");
    	helps.put("createRecipe", "createRecipe param1 param2 param3: Létrehoz egy új receptet.param1 a recept azonosítója, param2 inventoryjába kerül, param3 a recept típusa.");
    	helps.put("createGear", "createGear param1 param2 param3: Létrehoz egy új védőfelszerelést.param1 a védőfelszerelés azonosítója, param2 inventoryjába kerül, param3 a védőfelszerelés típusa.");
    	helps.put("createMaterial", "createMaterial param1 param2 param3: Létrehoz egy új anyagot. param1 az anyag azonosítója, param2 inventoryjába kerül, param3 a védőfelszerelés típusa.");
    	helps.put("createVirologist", "createVirologist param1 param2 param3: Létrehoz egy új virológust. param1 a virológus azonosítója, param2 tile-ra kerül, param3 a virológus típusa.");
    	helps.put("addNeighbour", "addNeighbour param1 param2: param1 és param2 tile mostantól szomszédosak.");
    	helps.put("saveGame", "saveGame param1: Elmenti a parancs kiadásáig felépített játékot. param1 néven fogja szerializált formában.");
    	helps.put("loadGame", "loadGame param1: Betölt egy param1 nevű szerializált játékot.");
    	helps.put("listTiles", "listTiles : Kilistázza a játékban lévő összes tile-t.");
    	helps.put("listNeighbours", "listNeighbours param1: kilistázza param1 azonosítójú tile összes szomszédját.");
    	helps.put("listVirologist", "listVirologist param1: Kilistázza param1 azonosítójú tile-on tartozkodó virológusokat.");
    	helps.put("listInventory", "listInventory param1: Kilistázza param1 azonosítójú dolog inventoryját.");
    	helps.put("listApplied", "listApplied param1: kilistázza param1 virológusra kent minden ágenst.");
    	helps.put("useAgent", "useAgent param1 param2 param3: Felhasználja a param1 azonosítójú ágenst a param2 virológus és rákeni az ágenst param3 virológusra.");
    	helps.put("useGear", "useGear param1 param2 param3: Felhasználja a param1 azonosítójú védőfelszerelést a param2 virológus és használja a param3 virológuson.");
    	helps.put("craftAgent", "craftAgent param1 param2: param1 virológus létrehoz egy param2 receptet.");
    	helps.put("move", "move param1 param2: param1 virológus átmozog param2 tile-ra.");
    	helps.put("step", "step param1: param1 azonosítójú dolgon lefut a step metódus.");
    	helps.put("rob", "rob param1 param2: param1 azonosítójú virológus kirabolja param2 virológust.");
    	helps.put("setJacket", "setJacket param1 param2: param1 azonosítójú köpenynek param2 állapotot állít be.");
    	helps.put("throwGear", "throwGear param1 param2: .param1 azonosítójú virológus eldobja param2 azonosítójú védőfelszerelését..");
    	helps.put("virologistDie", "virologistDie param1: param1 azonosítójú virológus meghal.");	
    	
    	if(helps.containsKey(command))System.out.println(helps.get(command));
    }
}
