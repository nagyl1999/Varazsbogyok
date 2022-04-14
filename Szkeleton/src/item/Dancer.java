package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Dancer.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import game.Tile;
import inventory.IInventoryVisitor;
import inventory.ItemNotFoundException;

import java.util.Random;

/**
 * A vitustáncot okozó ágens.
 */
public class Dancer extends Agent {
    /**
     * Ágnes élettartama
     */
    public static int EXPIRE = 10;

    /**
     * Konstruktor
     */
    public Dancer() {
        super(Dancer.EXPIRE);
    }

    /**
     * A vitustánc ágens léptetését szimuláló fügvény.
     */
    public void step() throws ItemNotFoundException {
        this.expire--;
        if (expire == 0)
            decompose(virologist);
    }

    /**
     * Véletlenszerű szomszéd index generálás
     */
    private Tile getRandomTile(Virologist v, int min, int max) {
        Random r = new Random();
        return v.getTile().getNeighbours().get(r.nextInt(max - min) + min);
    }

    /**
     * A függvény paraméterben kapott virológuson fogja kifejteni a hatását az ágens.
     */
    public void effect(Virologist v) {
        Tile t = getRandomTile(v, 0, v.getTile().getNeighbours().size());
        v.move(t);
        // TODO - nem tud lépni
    }

    /**
     * A függvény paraméterben kapott virológuson szünteti meg a felkent ágens hatását.
     */
    public void decompose(Virologist v) throws ItemNotFoundException {
        v.removeApplied(this);
        virologist = null;
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a vitustánc ágens típust.
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
     * Az ágens nincs hatással a rálépett mezőre
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
        v2.applyAgent(v2, this);
    }

}
