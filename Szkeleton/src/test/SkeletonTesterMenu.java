package test;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import game.Game;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;
import utils.RunnableWithException;

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
    private final HashMap<String, RunnableWithException> commands;
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
        commands.put("saveGame", TestCases::saveGame);
        commands.put("loadGame", TestCases::loadGame);
        commands.put("createTile", TestCases::createTile);
        commands.put("createVirologist", TestCases::createVirologist);
        commands.put("createAgent", TestCases::createAgent);
        commands.put("createRecipe", TestCases::createRecipe);
        commands.put("createGear", TestCases::createGear);
        commands.put("createMaterial", TestCases::createMaterial);
        commands.put("useAgent", TestCases::useAgent);
        commands.put("useGear", TestCases::useGear);
        commands.put("craftAgent", TestCases::craftAgent);
        commands.put("move", TestCases::move);
        commands.put("step", TestCases::step);
        commands.put("rob", TestCases::rob);
        commands.put("setJacket", TestCases::setJacket);
        commands.put("throwGear", TestCases::throwGear);
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
    			+ "A program egymás után dolgozza fel a parancsokat, helyes lefutás után executed, különben failed kimenet jelenik meg.\nA help + tesztparancs neve információt ad"
    			+ " a parancsról és a paramétereiről pl:help newGame  \nVárom a parancsokat:");
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
                //e.printStackTrace(); //nem standard outputra ír, hanem standard hibakimentre, szóval akár maradhat is 
            }
        }while (sc.hasNextLine());
    }
}
