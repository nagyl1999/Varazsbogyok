package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Recipe.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;
import inventory.IStorable;
import inventory.InventorySorterVisitor;

/**
 * A játék során elkészíthető ágensek receptjének az ősosztálya.
 */
public abstract class Recipe implements IStorable {
    /**
     * Recepthez szükséges aminoacid mennyiség
     */
    protected int aminoacid;
    /**
     * Recepthez szükséges nukleotid
     */
    protected int nucleoid;

    /**
     * Konstruktor, szükséges nyersanyag átvétele
     */
    public Recipe(int a, int n) {
        aminoacid = a;
        nucleoid = n;
    }

    /**
     * Getter - aminosav
     */
    public int getNumberOfAminoacid() {
        return aminoacid;
    }

    /**
     * Getter - nukleotid
     */
    public int getNumberOfNucleoid() {
        return nucleoid;
    }

    /**
     * A visitor tervezési mintát kihasználva a visitor megnézi, hogy az  ágens recepjéhez van-e
     * elegendő alapanyag.
     */
    public abstract boolean hasEnoughMaterial(InventorySorterVisitor i);

    /**
     * A recept használata után az visszaadja a kész ágenst.
     */
    public abstract Agent addAgent();

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni az ágens típust.
     */
    public abstract void accept(IInventoryVisitor i);

}
