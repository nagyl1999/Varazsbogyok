package test;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import game.Game;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A szkeleton működésére létrehozott teszter menü
 */
public class SkeletonTesterMenu implements Runnable {
    /**
     * Parancsok, és a hozzá tartozó azonosítók,
     * késöbb ez alapján hívjuk őket
     */
    private final HashMap<String, Runnable> commands;
    /**
     * Objektum - ID hozzárendelés
     */
    public static HashMap<String, Object> objects;
    /**
     * A beírt parancs
     */
    public static String cmd;


    /**
     * Menüpontok hozzáadása
     */
    private void init() throws IOException   {
    	
        commands.put("newGame", TestCases::newGame);
        commands.put("endGame", TestCases::endGame);
        commands.put("saveGame", () -> {
			try {
				TestCases.saveGame();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        commands.put("loadGame", () -> {
			try {
				TestCases.loadGame();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
        commands.put("createTile", TestCases::createTile);
        commands.put("createVirologist", TestCases::createVirologist);
        commands.put("createAgent", () -> {
			try {
				TestCases.createAgent();
			} catch (NotEnoughSpaceException e) {
				e.printStackTrace();
			}
		});
        commands.put("createRecipe", () -> {
			try {
				TestCases.createRecipe();
			} catch (NotEnoughSpaceException e) {
				e.printStackTrace();
			}
		});
        commands.put("createGear", () -> {
			try {
				TestCases.createGear();
			} catch (NotEnoughSpaceException e) {
				e.printStackTrace();
			}
		});
        commands.put("createMaterial", () -> {
			try {
				TestCases.createMaterial();
			} catch (NotEnoughSpaceException e) {
				e.printStackTrace();
			}
		});
        commands.put("useAgent", () -> {
			try {
				TestCases.useAgent();
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		});
        commands.put("useGear", TestCases::useGear);
        commands.put("craftAgent", () -> {
			try {
				TestCases.craftAgent();
			} catch (NotEnoughSpaceException e) {
				e.printStackTrace();
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		});
        commands.put("move", () -> {
			try {
				TestCases.move();
			} catch (NotEnoughSpaceException e) {
				e.printStackTrace();
			}
		});
        commands.put("step", () -> {
			try {
				TestCases.step();
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		});
        commands.put("rob", TestCases::rob);
        commands.put("setJacket", TestCases::setJacket);
        commands.put("throwGear", () -> {
			try {
				TestCases.throwGear();
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
			}
		});
        commands.put("virologistDie", TestCases::virologistDie);
        commands.put("addNeighbour", TestCases::addNeighbour);
        commands.put("listTiles", TestCases::listTiles);
        commands.put("listNeighbours", TestCases::listNeighbours);
        commands.put("listVirologist", TestCases::listVirologist);
        commands.put("listInventory", TestCases::listInventory); 
        commands.put("listApplied", TestCases::listApplied);
        commands.put("help", TestCases::help);

    }
    
    /**
     * Konstruktor
     * @throws IOException 
     */
    public SkeletonTesterMenu() throws IOException  {
        commands = new HashMap<>();
        objects = new HashMap<>();
        init();	
    }

    /**
     * Konzolról bekérendő adat, majd a megfelelő metódus futtatása
     */
    public void run() {
    	System.out.println("Üdvözöllek tesztelő! Te most a legendás V A R Á Z S B O G Y Ó K csapat ''A világtalan virológusok világa'' című játékát készülsz tesztelni.\n"
    			+ "A program egymás után dolgozza fel a parancsokat, helyes lefutás után executed, különben failed kimenet jelenik meg.  Várom a parancsokat!\n");
		Scanner sc=new Scanner(System.in);
		do {
			cmd=sc.nextLine();
            try {
            	String s = cmd.split(" ")[0];
            	if(commands.containsKey(s)) commands.get(s).run();
            	else continue;
				System.out.println(cmd + " executed");
            } catch (Exception e) {
				System.out.println(cmd + " failed");
                e.printStackTrace();
            }
        }while (sc.hasNextLine());
    }
}
