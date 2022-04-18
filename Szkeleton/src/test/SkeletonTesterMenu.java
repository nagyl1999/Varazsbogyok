package test;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import game.Game;

import java.util.HashMap;
import java.util.Scanner;

/**
 * A szkeleton működésére létrehozott teszter menü
 */
public class SkeletonTesterMenu implements Runnable {
    /**
     * Parancsok, és a hozzá tartozó azonosítók,
     * később ez alapján hívjuk őket
     */
    private final HashMap<Integer, Runnable> commands;
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
    private void init() {
        commands.put(0, TestCases::newGame);
    }

    /**
     * Konstruktor
     */
    public SkeletonTesterMenu() {
        commands = new HashMap<>();
        objects = new HashMap<>();
        init();
    }

    /**
     * Konzolról bekérendő adat, majd a megfelelő metódus futtatása
     */
    public void run() {

    }

}
