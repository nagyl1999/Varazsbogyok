package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Glove.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import inventory.IInventoryVisitor;
import inventory.Inventory;

/**
 * A játékban a kesztyű tipusú védőfelszerelés.
 */
public class Glove extends Gear {
    /**
     * A paraméterben kapott virológust megvédi a paraméterben kapott ágens ellen.
     *
     * @param v1 A Virológus aki az ágenst keni
     * @param v2 A Virológus akire az ágenst kenik
     * @param a  Az Ágens amit kennek a virológusra
     */
    public void protect(Virologist v1, Virologist v2, Agent a) {
        try {
            v2.removeApplied(a);
            v1.getApplied().add(a);
        } catch (Exception e) {
            System.out.println("Nincs ilyen felkent ágens a virológuson");
        }

    }

    /**
     * A paraméterben kapott virológus kiválasztja a kesztyűt.
     *
     * @param v A Virológus aki felveszi a kesztyűt
     */
    public void equip(Virologist v) {
        Inventory inventory = v.getInventory();
        try {
            inventory.addItem(this);
            this.accept((IInventoryVisitor) inventory);
        } catch (Exception e) {
            System.out.println("Nem lehet a kesztyűt felvenni!");
        }

    }

    /**
     * A paraméterben kapott virológus másik védőfelszerelésre vált.
     *
     * @param v A Virológus aki leadja a kesztyűt
     */
    public void unequip(Virologist v) {
        Inventory inventory = v.getInventory();
        try {
            inventory.removeItem(this);
        } catch (Exception e) {
            System.out.println("Nem lehet a kesztyűt leadni mert az nincs a virológusnál");
        }

    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a kesztyű típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

}
