package test;

import entity.Bot;
import entity.Player;
import entity.Virologist;
import game.*;
import inventory.IStorable;
import item.*;

import java.util.Scanner;

/**
 * Tesztesetek osztálya
 */
public class TestCases {

    /**
     * Bemenet olvasása, feltétel szerinti szűrés
     */
    public static int read(int max) {
        while (true) {
            try {
                System.out.print("Kategória: ");
                int cmd = new Scanner(System.in).nextInt();
                if (cmd > max || cmd < 0) {
                    System.out.println("Kívül esik a megengedett tartományon!");
                    continue;
                }
                return cmd;
            } catch (Exception e) {
                System.out.println("Helytelen bemenet!");
            }
        }
    }

    /**
     * Kilépés
     */
    public static void exit() {
        System.exit(0);
    }

    /**
     * Új játék indítása
     */
    public static void newGame() {
        Game.newGame();
    }

    /**
     * Játék befejezése
     */
    public static void endGame() {
        Game.exitGame();
    }

    /**
     * Játék vége, mert egy virológus nyert
     */
    public static void winGame() {
        Virologist v = new Player();
        Game.winGame(v);
    }

    /**
     * A virológus két mező között mozog
     */
    public static void virologistMoves() {
        Virologist v = new Player();
        Tile t1 = new Laboratory();
        Tile t2 = new Town();
        t1.addVirologist(v); // Szimuláljuk, hogy már rajta áll a mezőn
        v.move(t2);
    }

    /**
     * A virológus anyagot vesz fel
     */
    public static void pickUpMaterial() {
        Virologist v = new Bot();
        Tile t1 = new Storage();
        t1.addVirologist(v);
        System.out.println("Inventenroy.size: " + v.getInventory().size());
        v.pickUp(new Nucleoid());
        System.out.println("Inventenroy.size: " + v.getInventory().size());
    }

    /**
     * A virológus védőfelszerelést vesz fel
     */
    public static void pickUpGear() {
        Virologist v = new Bot();
        Tile t1 = new Town();
        Tile t2 = new Safehouse();
        t1.addVirologist(v);
        v.move(t2);
        System.out.println(v.getInventory().size());
    }

    /**
     * A virológus receptet vesz fel
     */
    public static void pickUpRecipe() {
        Virologist v = new Bot();
        Tile t1 = new Laboratory();
        t1.addVirologist(v);
        System.out.println("Inventenroy.size: " + v.getInventory().size());
        v.pickUp(new RDancer());
        System.out.println("Inventenroy.size: " + v.getInventory().size());
    }

    /**
     * A virológus ágenst ken fel
     */
    public static void useAgent() {
        Agent a;
        Virologist v1 = new Player();
        Virologist v2 = new Bot();
        switch (TestCases.read(3)) {
            case 0:
                a = new Paralyzer();
            case 1:
                a = new Forgetter();
            case 2:
                a = new Dancer();
            default:
                a = new Protector();
        }
        try {
            v1.getInventory().addItem(a);
            v1.useAgent(v2, a);
        } catch (Exception ignored) {
        }
    }

    /**
     * A virológus ágenst készít
     */
    public static void createAgent() {
        Virologist v = new Player();
        Recipe r;
        for (int i = 0; i < 5; i++) {
            try {
                v.getInventory().addItem(new Aminoacid());
                v.getInventory().addItem(new Nucleoid());
            } catch (Exception ignored) {
            }
        }
        switch (TestCases.read(3)) {
            case 0:
                r = new RParalyzer();
            case 1:
                r = new RForgetter();
            case 2:
                r = new RDancer();
            default:
                r = new RProtector();
        }
        try {
            v.makeAgent(r);
        } catch (Exception ignored) {
        }
    }

    /**
     * Egy virológus kirabol egy másik virológust
     */
    public static void rob() {
        Virologist v1 = new Player();
        Virologist v2 = new Bot();
        v2.setParalyzed(true);
        IStorable s1 = new Jacket();
        IStorable s2 = new Aminoacid();
        try {
            v2.getInventory().addItem(s1);
            v2.getInventory().addItem(s2);
        } catch (Exception ignored) {
        }
        v1.robVirologist(v2);
    }

    /**
     * Két virológus találkozik
     */
    public static void meet() {
        // TODO - ennek igazából van értelme?
        Virologist v1 = new Player();
        Virologist v2 = new Bot();
        Tile t1 = new Laboratory();
        Tile t2 = new Town();
        t1.addVirologist(v1);
        t2.addVirologist(v2);
        v1.move(t2);
    }

    /**
     * Ágens elbomlása
     */
    public static void decompose() {
        Agent a;
        Virologist v = new Player();
        switch (TestCases.read(3)) {
            case 0:
                a = new Paralyzer();
            case 1:
                a = new Forgetter();
            case 2:
                a = new Dancer();
            default:
                a = new Protector();
        }
        v.getApplied().add(a);
        try {
            a.decompose(v);
        } catch (Exception ignored) {
        }
    }

}
