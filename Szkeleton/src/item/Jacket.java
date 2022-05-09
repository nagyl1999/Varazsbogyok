package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Jacket.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import inventory.IInventoryVisitor;
import inventory.Inventory;

/**
 * A játékban a kabát tipusú védőfelszerelés.
 */
public class Jacket extends Gear {
    /**
     * Sikeres védekezés valószínűsége
     */
    public double success = 0.823;
    /**
     * Ikon elérési út
     */
    protected String iconPath = "";
    /**
     * Hátralévő használatok száma
     */
    public static int DURABILITY = -1;

    /**
     * Konstruktor
     */
    public Jacket() {
        super(Jacket.DURABILITY);
    }

    /**
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * A paraméterben kapott virológust megvédi a paraméterben kapott ágens ellen 82,3%-os hatásfokkal
     *
     * @param v1 A Virológus aki az ágenst keni
     * @param v2 A Virológus akire az ágenst kenik
     * @param a  Az Ágens amit kennek a virológusra
     */
    public void protect(Virologist v1, Virologist v2, Agent a) {

        double d = Math.random();

        if (d < success)
            try {
                v1.removeApplied(a);
            } catch (Exception e) {
                System.out.println("Már nincs rajta az ágens.");
            }

    }

    /**
     * A paraméterben kapott virológus kiválasztja a kabátot.
     *
     * @param v A Virológus aki felveszi a kabátot
     */
    public void equip(Virologist v) {
        equipped = true;
    }

    /**
     * A paraméterben kapott virológus másik védőfelszerelésre vált.
     *
     * @param v A Virológus aki leadja a zsákot
     */
    public void unequip(Virologist v) {
        equipped = false;
    }

    /**
     * A felszerelést nem lehet használni
     */
    public void use(Virologist v) {
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a kabát típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }


}
