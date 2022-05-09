package item;

import entity.Virologist;
import game.Tile;
import game.Timer;
import inventory.IInventoryVisitor;
import inventory.Inventory;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;

import java.util.Random;

/**
 * Medvevírust okozó ágens
 */
public class Bear extends Agent {
    /**
     * Ikon elérési út
     */
    protected String iconPath = "";
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
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
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
    public void effect(Virologist v) throws NotEnoughSpaceException {
        Tile t = getRandomTile(v, 0, v.getTile().getNeighbours().size());
        v.getTile().removeVirologist(v);
        t.addVirologist(v);
        v.setTile(t);
        t.interactedWith(v);
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
        virologist = v2;
        v2.applyAgent(null, this);
    }

    /**
     * Az ágens mezőre kifejtett hatása, a medveágens kiüríti a rálépett mező inventory-ját
     */
    public void effect(Tile t) {
        Inventory i = t.getInventory();
        i.reset();
        try {
            while (i.hasNext())
                i.removeItem(i.next());
        } catch (Exception ignore) {
        }
    }

    /**
     * A medvevírus nem romlik meg
     */
    public void step() {
        Timer.getInstance().tick();
    }

    /**
     * Visitor minta
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }
}
