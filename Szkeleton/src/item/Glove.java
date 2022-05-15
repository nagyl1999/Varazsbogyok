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
import inventory.ItemNotFoundException;

/**
 * A játékban a kesztyű tipusú védőfelszerelés.
 */
public class Glove extends Gear {
    /**
     * Ikon elérési út
     */
    protected String iconPath = "resources\\glove3" + "" + ".jpg";
    /**
     * Hátralévő használatok száma
     */
    public int DURABILITY = 3;

    /**
     * Konstruktor
     */
    public Glove() {
        super(3);
    }

    /**
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * A paraméterben kapott virológust megvédi a paraméterben kapott ágens ellen.
     *
     * @param v1 A Virológus akire az ágenst kenik
     * @param v2 A Virológus aki az ágenst keni
     * @param a  Az Ágens amit kennek a virológusra
     */
    public void protect(Virologist v1, Virologist v2, Agent a) {
        System.out.println("Durability " + durability);
        try {
            v1.removeApplied(a);
            v2.getApplied().add(a);
            DURABILITY--;
            iconPath = "resources\\glove" + DURABILITY + ".jpg";
            if(DURABILITY==0)
                v1.getInventory().removeItem(this);
        } catch (ItemNotFoundException ignore) {
            System.out.println("Nincs ilyen felkent ágens a virológuson");
        } catch (Exception e) {
            System.out.println("Nem lehet visszakenni");
            //DURABILITY--;
            //iconPath = "resources\\glove" + DURABILITY + ".jpg";
        }
    }

    /**
     * A paraméterben kapott virológus kiválasztja a kesztyűt.
     *
     * @param v A Virológus aki felveszi a kesztyűt
     */
    public void equip(Virologist v) {
        equipped = true;
    }

    /**
     * A felszerelést nem lehet használni
     */
    public void use(Virologist v1, Virologist v2) {
    }

    /**
     * A paraméterben kapott virológus másik védőfelszerelésre vált.
     *
     * @param v A Virológus aki leadja a kesztyűt
     */
    public void unequip(Virologist v) {
        equipped = false;
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a kesztyű típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

}
