package item;

import java.io.Serializable;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Gear.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import graphics.IIcon;
import inventory.IInventoryVisitor;
import inventory.IStorable;
import item.Agent;

/**
 * A védőfelszerelések ősosztálya.A virológusok ezek védelem céljából veszik fel
 */
public abstract class Gear implements IStorable, IUsable, Serializable {
    /**
     * Tárolja, hogy az aktuális védőfelszerelés használatban van.
     */
    protected boolean equipped;
    /**
     * Elkopásig hátralévő használatok száma
     */
    protected int durability;

    /**
     * Konstruktor
     */
    public Gear(int d) {
        durability = d;
    }

    /**
     * Getter - Ikon elérési út
     */
    public abstract String getIconPath();

    /**
     * A paraméterben kapott virológust megvédi a paraméterben kapott ágens ellen.
     */
    public abstract void protect(Virologist v1, Virologist v2, Agent a);

    /**
     * A paraméterben kapott virológus kiválasztja a védőfelszerelést
     */
    public abstract void equip(Virologist v);

    /**
     * A paraméterben kapott virológus másik védőfelszerelésre vált.
     */
    public abstract void unequip(Virologist v);

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni az ágens típust.
     */
    public abstract void accept(IInventoryVisitor i);

    /**
     * A felszerelés használata, ezt a felszerelések külön definiálják
     */
    public abstract void use(Virologist v1, Virologist v2);

    public abstract boolean contains(Virologist v1);

}
