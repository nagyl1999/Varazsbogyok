package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.RDancer.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;
import inventory.InventorySorterVisitor;

/**
 * A vitustáncot okozó ágens receptje.
 */
public class RDancer extends Recipe {

    /**
     * A vitustáncot okozó ágenshez szükséges anyagok számai.
     */
    public static int numberOfAminoAcid = 3;
    public static int numberOfNucleoid = 2;

    /**
     * Konstruktor
     */
    public RDancer() {
        super(RDancer.numberOfAminoAcid, RDancer.numberOfNucleoid);
    }

    /**
     * A visitor tervezési mintát kihasználva a visitor megnézi, hogy a vitus táncot okozó ágens recepjéhez van-e
     * elegendő alapanyag.
     */
    public boolean hasEnoughMaterial(InventorySorterVisitor i) {
        if (i.getAminoacidItems().size() >= numberOfAminoAcid && i.getNucleoidItems().size() >= numberOfNucleoid) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a vitustánc ágens receptje típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }


    /**
     * A recept használata után az visszaadja a kész ágenst.
     */
    @Override
    public Agent addAgent() {
        return new Dancer();
    }
}
