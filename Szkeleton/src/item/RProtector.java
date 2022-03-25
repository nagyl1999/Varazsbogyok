package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.RProtector.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;
import inventory.InventorySorterVisitor;

/**
 * A védelem  ágens receptje.
 */
public class RProtector extends Recipe {

    /**
     * A vitustáncot okozó ágenshez szükséges anyagok számai.
     */
    private final int numberOfAminoAcid = 2;
    private final int numberOfNucleoid = 3;

    /**
     * A visitor tervezési mintát kihasználva a visitor megnézi, hogy a védelem ágens recepjéhez van-e
     * elegendő alapanyag.
     */
    @Override
    public boolean hasEnoughMaterial(InventorySorterVisitor i) {
        if (i.getAminoacidItems.size() >= numberOfAminoAcid && i.nucleoidItems.size() >= numberOfNucleoid) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A recept használata után az visszaadja a kész ágenst.
     */
    @Override
    public Agent addAgent() {
        return new Protector();
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a védelem ágens receptje típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

    /**
     * Az anyagok számainak lekérdezéséhez szükséges függvények.
     */
    public int getNumberOfAminoAcid() {
        return numberOfAminoAcid;
    }

    public int getNumberOfNucleoid() {
        return numberOfNucleoid;
    }


}
