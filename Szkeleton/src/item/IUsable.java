package item;

import entity.Virologist;
import inventory.ItemNotFoundException;

/**
 * A használható dolgok összefoglaló
 * interfésze
 */
public interface IUsable {
    /**
     * Dolog használata
     *
     * @param v1 A használó virológus
     * @param v2 Akin használjuk
     */
    public void use(Virologist v1, Virologist v2) throws ItemNotFoundException;
}
