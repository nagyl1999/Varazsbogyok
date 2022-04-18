package test;

import entity.Bot;
import entity.Player;
import entity.Virologist;
import game.*;
import inventory.IStorable;
import inventory.Inventory;
import item.*;

import java.util.Scanner;

/**
 * Tesztesetek osztálya
 */
public class TestCases {
    // TODO - executed / failed

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
     * Új játék létrehozása
     */
    public static void newGame() {
        int tileCount = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[1]);
        Game.newGame();
        // TODO - tile generálás
    }

    /**
     * Játék vége
     */
    public static void endGame() {
        // Game.map = null;
        // TODO - Game map static
        for (String key : SkeletonTesterMenu.objects.keySet())
            SkeletonTesterMenu.objects.remove(key);
    }

    /**
     * Mező létrehozása
     */
    public static void createTile() {
        String tileId = SkeletonTesterMenu.cmd.split(" ")[1];
        int type = Integer.parseInt(SkeletonTesterMenu.cmd.split(" ")[2]);
        // TODO - tile létrehozása
    }

    /**
     * Virológus létrehozása
     */
    public static void createVirologist() {
        // TODO -
    }

    /**
     * Ágens létrehozása
     */
    public static void createAgent() {
        // TODO -
    }

    /**
     * Recept létrehozása
     */
    public static void createRecipe() {
        // TODO -
    }

    /**
     * Felszerelés létrehozása
     */
    public static void createGear() {
        // TODO -
    }

    /**
     * Felszerelés létrehozása
     */
    public static void createMaterial() {
        // TODO -
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
     */
    public static void saveGame() {
        // TODO - játék mentése
    }

    /**
     * Játék betöltése
     */
    public static void loadGame() {
        // TODO - játék betöltése
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
        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(virId);
        Inventory i = v.getInventory();

        i.reset();
        while (i.hasNext())
            System.out.println(getKeyByObj(i.next()));
    }

    /**
     * Ágens használata
     */
    public static void useAgent() {
        // TODO -
    }

    /**
     * Felszerelés használata
     */
    public static void useGear() {
        // TODO -
    }

    /**
     * Ágens létrehozása
     */
    public static void craftAgent() {
        // TODO -
    }

    /**
     * Virológus léptetése
     */
    public static void move() {
        // TODO -
    }

    /**
     * Léptethető dolgok léptetése
     */
    public static void step() {
        // TODO -
    }

    /**
     * Virológus kirablása
     */
    public static void rob() {
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
        // TODO -
    }

    /**
     * Felszerelés eldobása
     */
    public static void throwGear() {
        // TODO -
    }

    /**
     * Virológus meghal
     */
    public static void virologistDie() {
        String virId = SkeletonTesterMenu.cmd.split(" ")[1];
        Virologist v = (Virologist) SkeletonTesterMenu.objects.get(virId);
        v.die();
    }

}
