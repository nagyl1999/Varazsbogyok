package inventory;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : inventory.VisitorManager.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import game.Game;
import item.*;

import java.util.ArrayList;

/**
 * A VisitorManager osztály felel minden olyan kérdésre,
 * amely az inventory tartalmával kapcsolatosan vetődik fel
 * elkerülve a TypeCheck-et
 */
public class VisitorManager {

    /**
     * Egy inventory tartalmának szétválogatása, amennyiben van zsák, azét is megnézzük
     */
    public static InventorySorterVisitor sortInventory(IInventoryHolder e) {
        InventorySorterVisitor i = new InventorySorterVisitor();
        e.getInventory().accept(i);
        if (i.getBagItems().size() > 0) {
            for (Bag b : i.getBagItems()) {
                b.getInventory().accept(i);
            }
        }
        return i;
    }

    /**
     * Megvizsgáljuk, hogy egy adott virológus minden
     * receptel rendelkezik-e, amennyiben igen, meghívjuk
     * a Game.WinGame függvényt
     */
    public static void hasWonTheGame(Virologist e) {
        InventorySorterVisitor i = sortInventory(e);
        if (i.getRdancerItems().size() > 0 && i.getRforgetterItems().size() > 0 && i.getRpalaryzerItems().size() > 0 && i.getRprotectorItems().size() > 0)
            Game.winGame(e);

    }

    /**
     * Egy recept előállítása az inventory-ban található
     * anyagok, és a kapott recept segítségével
     */
    public static boolean craftRecipe(Virologist v, Recipe r) {
        InventorySorterVisitor i = sortInventory(v);
        return r.hasEnoughMaterial(i);
    }

    /**
     * Ellopható objektumok a birtokos inventory-jából,
     * ide tartoznak az anyagok és a védőfelszerelések
     */
    public static ArrayList<IStorable> getStealable(Virologist v) {
        InventorySorterVisitor i = sortInventory(v);
        ArrayList<IStorable> items = new ArrayList<>();
        items.addAll(i.getAxeItems());
        items.addAll(i.getBagItems());
        items.addAll(i.getGloveItems());
        items.addAll(i.getJacketItems());
        items.addAll(i.getNucleoidItems());
        items.addAll(i.getAminoacidItems());
        return items;
    }

    /**
     * Gear típusú objektumok lekérése a virológusnál
     * található dolgok közül
     */
    public static ArrayList<Gear> getGear(Virologist v) {
        InventorySorterVisitor i = sortInventory(v);
        ArrayList<Gear> items = new ArrayList<>();
        items.addAll(i.getBagItems());
        items.addAll(i.getJacketItems());
        items.addAll(i.getGloveItems());
        return items;
    }

    /**
     * Van-e táska az inventory-ban
     */
    public static boolean containsGear(Virologist v, Bag g) {
        InventorySorterVisitor i = sortInventory(v);
        return i.getBagItems().size() > 0;
    }

    /**
     * Van-e kesztyű az inventory-ban
     */
    public static boolean containsGear(Virologist v, Glove g) {
        InventorySorterVisitor i = sortInventory(v);
        return i.getGloveItems().size() > 0;
    }

    /**
     * Van-e köpeny az inventory-ban
     */
    public static boolean containsGear(Virologist v, Jacket g) {
        InventorySorterVisitor i = sortInventory(v);
        return i.getJacketItems().size() > 0;
    }

    /**
     * A virológusunk medvevírussal fertőzött-e
     */
    public static boolean hasBear(Virologist v) {
        InventorySorterVisitor i = new InventorySorterVisitor();
        for (Agent a : v.getApplied())
            a.accept(i);
        return i.getBearItems().size() > 0;
    }

    /**
     * A virológusunk bénítóágensel fertőzött-e
     */
    public static boolean hasParalyzer(Virologist v) {
        InventorySorterVisitor i = new InventorySorterVisitor();
        for (Agent a : v.getApplied())
            a.accept(i);
        return i.getParalyzerItems().size() > 0;
    }

    /**
     * A virológusunk táncoságenssel fertőzött-e
     */
    public static boolean hasDancer(Virologist v) {
        InventorySorterVisitor i = new InventorySorterVisitor();
        for (Agent a : v.getApplied())
            a.accept(i);
        return i.getDancerItems().size() > 0;
    }

}
