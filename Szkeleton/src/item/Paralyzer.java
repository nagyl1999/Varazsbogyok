package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Paralyzer.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import game.Tile;
import inventory.IInventoryVisitor;
import inventory.ItemNotFoundException;
import item.Agent;

/**
 * Bénulást okozó ágens
 */
public class Paralyzer extends Agent {
    /**
     * Ágnes élettartama
     */
    public static int EXPIRE = 8;

    /**
     * Konstruktor
     */
    public Paralyzer() {
        super(Paralyzer.EXPIRE);
    }

    /**
     * A bénulás ágens léptetését szimuláló fügvény.
     */
    public void step() throws ItemNotFoundException {
        this.expire--;
        if(expire == 0)
            decompose(virologist);
    }

    /**
     * A függvény paraméterben kapott virológuson fogja kifejteni a hatását az ágens.
     */
    public void effect(Virologist v) {
        v.setParalyzed(true);
    }

    /**
     * A függvény paraméterben kapott virológuson szünteti meg a felkent ágens hatását.
     */
    public void decompose(Virologist v) throws ItemNotFoundException {
        v.setParalyzed(false);
        v.removeApplied(this);
        virologist = null;
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a bénító ágens típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

    /**
     * Az ágens vírus típusú, így nincs védő hatása.
     */
    public void protect(Virologist v, Agent a) {
    }

    /**
     * Az ágensnek nincs hatása a rálépett mezőre
     */
    public void effect(Tile t) {
    }

    /**
     * Az ágens felhasználására irányuló függvény.
     *
     * @param v1 A felhasználó
     * @param v2 Az elszenvedő
     */
    public void use(Virologist v1, Virologist v2) throws ItemNotFoundException {
        virologist = v2;
        v2.applyAgent(v1, this);
    }

}
