package item;

import entity.Virologist;
import game.Tile;
import inventory.IInventoryVisitor;
import inventory.ItemNotFoundException;

/**
 * Medvevírust okozó ágens
 */
public class Bear extends Agent {

    /**
     * Véletlenszerű lépésre kényszeríti a játékost
     */
    public void effect(Virologist v) {

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
        v2.applyAgent(v1, this);
    }

    /**
     * Az ágens mezőre kifejtett hatása, a medveágens kiüríti a rálépett mező inventory-ját
     */
    public void effect(Tile t) {
        // TODO
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
