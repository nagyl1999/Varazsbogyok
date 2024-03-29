package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.RPalaryzer.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import game.Game;
import inventory.IInventoryVisitor;
import inventory.InventorySorterVisitor;

/**
 * A bénulást okozó ágens receptje.
 */
public class RParalyzer extends Recipe {
    /**
     * Ikon elérési út
     */
    protected String iconPath = "resources\\RParalyzer.jpg";
    /**
     * A vitustáncot okozó ágenshez szükséges anyagok számai.
     */
    public static int numberOfAminoAcid = 4;
    public static int numberOfNucleoid = 3;

    /**
     * Konstruktor
     */
    public RParalyzer() {
        super(RParalyzer.numberOfAminoAcid, RParalyzer.numberOfNucleoid);
    }

    /**
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * A visitor tervezési mintát kihasználva a visitor megnézi, hogy a bénulást okozó ágens recepjéhez van-e
     * elegendő alapanyag.
     */
    public boolean hasEnoughMaterial(InventorySorterVisitor i) {
        return (i.getAminoacidItems().size() >= numberOfAminoAcid && i.getNucleoidItems().size() >= numberOfNucleoid);
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a bénulás ágens receptje típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

    /**
     * A recept használata után az visszaadja a kész ágenst.
     */
    @Override
    public Agent addAgent() {
        Agent a = new Paralyzer();
        Game.timer.addSteppable(a);
        return a;
    }
}