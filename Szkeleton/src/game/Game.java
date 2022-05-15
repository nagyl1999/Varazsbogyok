package game;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : game.Game.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Bot;
import entity.Player;
import entity.Virologist;
import graphics.VarazsbogyokFrame;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;
import item.*;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Random;
/**
 * Játék objektum, felelőssége a játék elindítása, időzitő beállítása. A pálya generálása.
 */
public final class Game implements Serializable {
    /**
     * JÃtéktér
     */
    public static Map map;
    /**
     * A játékban a pályaelemek száma
     */
    public static int tileCount = 200;
    /**
     * Minimum mezők
     */
    public static int minTileCount = 10;
    /**
     * A játékban a botok száma
     */
    public static int botCount = 3;
    /**
     * Minimum botok
     */
    public static int minBotCount = 3;
    /**
     * A játékban az egyes pályaelemek maximális szomszédjaa
     */
    public static int maxNeighbours = 4;
    /**
     * A játékban az idÅőzítő
     */
    public static Timer timer;
    /**
     * Aktív virológus
     */
    public static Virologist activeVirologist;
    /**
     * voronoj pontok minimum távolsága egymástól
     */
    public static int minDistance = 20;
    /**
     * voronoj alakzatok közötti vonal szélessége
     */
    public static int linethickness = 2;
    /**
     * maximum tile-ok száma
     */
    public static int maxTiles = 50;
    

    /**
     * Konstruktor
     */
    public Game() {
    }

    /**
     * pálya és timer létrehozása.
     */
    public static void newGame() {
        map = new Map();
        timer = Timer.getInstance();
        generateRandomMap();
        addRandomVirologists();
        timer.tick();
    }
    /**
     * véletlenszerűen teszi le a játékost
     * a játéos által megadott botot generál és teszi le véletlenszerű helyre
     */
    public static void addRandomVirologists() {
        Random r = new Random();
        Tile t = map.getTiles().get(r.nextInt(map.getTiles().size()));
        Player v = new Player();
        timer.addSteppable(v);
        t.addVirologist(v);
        try {
            for (int j = 0; j < 10; j++)
                v.getInventory().addItem(new Jacket());
        }catch(Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < Game.botCount; i++) {
            Bot bot = new Bot();
            timer.addSteppable(bot);
            t.addVirologist(bot);
        }
    }
    /**
     * véletlenszerű voronoj pontokat generál
     */
    public static void randomTilePoints() {
    	//TODO
        int x, y;
    	ArrayList<Vec2> exceptions = new ArrayList<>();
        for (int i =0; i< tileCount;i++) {
            do{
                //double dy = VarazsbogyokFrame.getInstance().getSize().getHeight()-40; // JPanelé kell!!
                //double dx = VarazsbogyokFrame.getInstance().getSize().getWidth()-40;//Jppanelé kell!!!
                double dx =460;
                double dy = 760;
                x = randInt(0, (int)dx, 2);
                y = randInt(0, (int)dy, 2);
            }
            while(equals(exceptions, new Vec2(x, y)) || accept(new Vec2(x,y)));
            exceptions.add(new Vec2(x,y));
            Tile t = randomTile();
            t.setX(x);
            t.setY(y);
            map.addTile(t);
        }
        
        for(int i = 0; i < tileCount;i++) {
        	Circle c = new Circle(new Vec2(map.getTiles().get(i).getX(),map.getTiles().get(i).getY()));
        	map.getTiles().get(i).setCircle(c.getCircle());
        }
        
       
    }
    /**
     * összehasonlítja egy arraylist pontjait egy adott ponttal 
     */
    public static boolean equals(ArrayList<Vec2> e, Vec2 a) {
        for (Vec2 v : e)
            if (v.getX() == a.getX() && v.getY() == a.getY())
                return true;
        return false;
    }
    /**
     * visszaadja, hogy a paraméterben kapott pont és  bármely eddig elkészült voronoj pont távolsága kisebb e mint mint a minDistance 
     */
    public static boolean accept(Vec2 a){
        for(int i = 0;i< map.getTiles().size();i++){
            if(a.getDistance(new Vec2(map.getTiles().get(i).getX(),map.getTiles().get(i).getY())) <minDistance) return true;
        }
        return false;
    }
    /**
     * véletlenszám, kezdőérték,utolsó érték, mennyi legyen a számok között az eltérés
     */
    public static int randInt(int first, int last, int step) {
    	//TODO
        int nsteps = (last+1-first) / step;
        return first + step*(int)(nsteps*Math.random());
    }
    /**
     * minden pontra kiszámítja, hogy melyik voroni ponthoz tartozik , ezenfelül beállítja az egyes voronoi
     * cellák közötti vonal vastagságot
     * minden tile-nak beállítja a szomszédait
     */
    public static void generateRandomMap() {
 
    	randomTilePoints();

    	for(int x = 0; x < VarazsbogyokFrame.getInstance().jatek.getWidth();x++) {
    		for(int y =0; y < VarazsbogyokFrame.getInstance().jatek.getHeight();y++ ) {
    			double distance = 800*500;
    			int choosen = 0;
    			int choosen2 = 0;
    			for(int i = 0; i < tileCount;i++) {
    				double temp = new Vec2(x, y).getDistance(new Vec2(map.getTiles().get(i).getX(),map.getTiles().get(i).getY()));
                    if(temp < distance){
                        distance = temp;
                        choosen = i;
                        choosen2 = i;
                    }
    			}
                distance = 800*500;
                for(int i = 0; i < tileCount;i++) {
                    if (i == choosen)
                        continue;
                    double temp = new Vec2(x, y).getDistance(new Vec2(map.getTiles().get(i).getX(),map.getTiles().get(i).getY()));
                    if(temp < distance){
                        distance = temp;
                        choosen2 = i;
                    }
                }
    			
    			double t1 = new Vec2(x,y).getDistance( new Vec2(map.getTiles().get(choosen).getX(),map.getTiles().get(choosen).getY() ));
                double t2 = new Vec2(x,y).getDistance( new Vec2(map.getTiles().get(choosen2).getX(),map.getTiles().get(choosen2).getY() ));

                if(Math.abs(t1-t2)>linethickness) { map.getTiles().get(choosen).getPoints().add(new Vec2(x,y));}
                else  {map.getTiles().get(choosen).getBorderPolly().add(new Vec2(x,y));
                } 
    		}
    	}
    	
    	for(int i = 0; i < tileCount;i++) {
    		map.getTiles().get(i).makePolly();
    		
    	}
    	
    	for(Tile t1 : map.getTiles()) {
    		
    		for(Tile t2 : map.getTiles()) {
    			if(t1 == t2) continue;
    			if(t1.getNeighbours().contains(t2)) continue;
    		  pont: for(Vec2 p : t1.getBorderPolly()){
    				for(Vec2 q : t2.getBorderPolly()) {
    					double d = p.getDistance(q);
		    			if(d==1){
		    			t1.addNeighbour(t2);
		    			t2.addNeighbour(t1);
		    			break pont;}
		    		}
    			}
    		}
    	}
    }

    /**
     * Pályagenerálás, beállít egy véletenszerű pályát.
     */
    public static void generateRandomMap2() {
        ArrayList<Integer> neighbours = new ArrayList<Integer>();
        for (int i = 0; i < tileCount; i++) map.addTile(randomTile());
        for (int i = 0; i < tileCount; i++) {
            neighbours.clear();
            //itt felépitjuk az esetleges szomszédok listáját, kivéve a soron lévő elemet
            for (int j = 0; j < tileCount; j++) if (i != j) neighbours.add(j);
            /* Itt fogjuk a szomszédokat beállitani, egy pályaelemnek legfeljebb
             * maxNeighbours szomszéja lehet, ezutÃ¡n hozzÃ¡adunk a neighbours listÃ¡bol egyet,
             * miutÃ¡n hozzÃ¡adtuk kivesszÃ¼k a neighbours listÃ¡bol az elemet, igy a listÃ¡ban
             * csak olyan elemek maradnak amik mÃ©g nem szomszÃ©dosak az adott pÃ¡lyaelemmek*/
            Random r = new Random();
            for (int j = 0; j < r.nextInt(maxNeighbours); j++) {
                int n = r.nextInt(tileCount - j - 1);
                map.getTiles().get(i).addNeighbour(map.getTiles().get(n));
                neighbours.remove(n);
            }
        }
        //játékos létrehozása és hozzáadaása a léptethető osztályhoz
        map.getTiles().get(0).addVirologist(new Player());
        timer.addSteppable(map.getTiles().get(0).getVirologist().get(0));
        //botok létrehozása és hozzáadása a léptethető dolgokhoz
        for (int i = 1; i <= botCount; i++) {
            map.getTiles().get(i).addVirologist(new Bot());
            timer.addSteppable(map.getTiles().get(i).getVirologist().get(0));
        }
    }

    /**
     * Játékból való kilépés
     */
    public static void exitGame() {
        System.out.println("A jÃ¡tÃ©knak vÃ©ge :/");

    }

    /**
     * Egy virológus megnyerte a játékot
     */
    public static void winGame(Virologist v) {
        System.out.println("A játékot " + v.toString() + " nyerte");
    }

    /**
     * Egy véletlenszeru pályaelemet generál
     */
    public static Tile randomTile() {
        Random r = new Random();
        int n = r.nextInt(11);
        Town town = new Town();
        town.setColor(Color.green);
        
        if(n == 4 || true) {
        	BearLaboratory bearlaboratory = new BearLaboratory();
            bearlaboratory.setColor(Color.red);
        	return bearlaboratory;
        }
        if(n == 5 || n == 6) {
        	SafeLaboratory safelaboratory = new SafeLaboratory();
        	safelaboratory.setColor(Color.red);
            return  safelaboratory;
        }
        if(n == 7 || n ==8) {
        	Safehouse safehouse = new Safehouse();
        	safehouse.setColor(Color.blue);
            return safehouse;
        }
        if(n == 9 || n ==10) {
        	Storage storage = new Storage();
        	storage.setColor(Color.yellow);
            return  storage;
        }
        return town;
    }
}