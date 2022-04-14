package item;

import entity.Virologist;
import game.Tile;
import inventory.IInventoryVisitor;
import inventory.ItemNotFoundException;

import java.util.Random;

/**
 * Medvevírust okozó ágens
 */
public class Bear extends Agent {
    /**
     * Ágnes élettartama
     */
    public static int EXPIRE = -1;

    /**
     * Konstruktor
     */
    public Bear() {
        super(Bear.EXPIRE);
    }

    /**
     * Véletlenszerű szomszéd index generálás
     */
    private Tile getRandomTile(Virologist v, int min, int max) {
        Random r = new Random();
        return v.getTile().getNeighbours().get(r.nextInt(max - min) + min);
    }

    /**
     * Véletlenszerű lépésre kényszeríti a játékost
     */
    public void effect(Virologist v) {
        Tile t = getRandomTile(v, 0, v.getTile().getNeighbours().size());
        v.move(t);
        // TODO - nem tud többet lépni
    }

    /**
     * A medvevírus nem tud magától elbomlani
     */
    public void decompose(Virologist v) throws ItemNotFoundException {
    }

    /**
     * A medvevírus nem véd
     */
    public void protect(Virologist v, Agent a) throws ItemNotFoundException {
    }

    /**
     * A medvevírus felkenése egy virológusra, jelen esetben mindkettő virológus
     * az elszenvedő lesz, mivel csak mező használhatja.
     *
     * @param v1 Elszenvedő virológus
     * @param v2 Elszenvedő virológus
     * @throws ItemNotFoundException Ha nem található az ágens a játékos inventory-jában
     */
    public void use(Virologist v1, Virologist v2) throws ItemNotFoundException {
        // TODO - hogy védekezünk ellene, kire ken a kesztyű
        virologist = v2;
        v2.applyAgent(v1, this);
    }

    /**
     * Az ágens mezőre kifejtett hatása, a medveágens kiüríti a rálépett mező inventory-ját
     */
    public void effect(Tile t) {
        // TODO - inventory ürítése
    }

    /**
     * A medvevírus nem romlik meg
     */
    public void step() {
    }

    /** Visitor minta */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }
}
