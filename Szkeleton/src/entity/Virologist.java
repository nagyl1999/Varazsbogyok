package entity;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : entity.Virologist.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import game.Steppable;
import game.Tile;
import inventory.*;
import item.*;
import item.AgentComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Egy közös entitás működését szimuláló osztály
 */
public abstract class Virologist implements Steppable, IInventoryHolder {
    /**
     * Mező, amelyen a virológus jelenleg áll
     */
    protected Tile tile;
    /**
     * A virológusunk állapotát tároló változó
     */
    protected boolean paralyzed;
    /**
     * A virológushoz tartozó inventory
     */
    protected Inventory inventory;
    /**
     * A virológusra felkent ágensek
     */
    protected ArrayList<Agent> applied;

    /**
     * Getter - Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Getter - Felkent ágensek
     */
    public ArrayList<Agent> getApplied() {
        return applied;
    }

    /**
     * Getter - Paralyzed
     */
    public boolean getParalyzed() {
        return paralyzed;
    }

    /**
     * Ágens felkenése a virológusra, ágensek rendezése a konzisztens
     * állapot fenttartása érdekében, mielőtt
     */
    public void applyAgent(Agent a) {
        applied.add(a);
        for (Gear g : VisitorManager.getGear(this))
            g.protect(this, a);
        for (Agent g : getApplied())
            g.protect(this, a);
        sortApplied();
    }

    /**
     * Ágens leszedése a virológusról
     */
    public void removeApplied(Agent a) throws ItemNotFoundException {
        if (!applied.contains(a))
            throw new ItemNotFoundException("Ilyen ágens nincs felkenve!");
        applied.remove(a);
    }

    /**
     * A virológus bénult állapotának beállítása
     */
    public void setParalyzed(boolean p) {
        paralyzed = p;
    }

    /**
     * Felkent ágensek lejárati idő szerinti növekvő sorbarendezése
     */
    public void sortApplied() {
        applied.sort(new AgentComparator());
    }

    /**
     * A virológus másik mezőre léptetése
     */
    public void move(Tile t) {
        if (getParalyzed())
            return;
        tile.removeVirologist(this);
        t.acceptVirologist(this);
    }

    /**
     * Egy másik virológus kirablása
     */
    public void robVirologist(Virologist v) throws ItemNotFoundException, NotEnoughSpaceException {
        if (!v.getParalyzed())
            return;
        Inventory i = v.getInventory();
        while (getInventory().hasSpace() && i.hasNext()) {
            IStorable item = i.next();
            i.removeItem(item);
            getInventory().addItem(item);
        }
    }

    /**
     * Egy ágens recept alapján való létrehozása
     */
    public void makeAgent(Recipe r) {
        if (!VisitorManager.craftRecipe(this, r)) {
            return;
        } else {
            int numberOfAminoacid = r.getNumberOfAminoacid();
            int numberOfNucleoid = r.getNumberOfNucleoid();

            for (int i = 0; i < numberOfAminoacid; i++) {
                InventorySorterVisitor inventorySorterVisitor = VisitorManager.sortInventory(this);
                ArrayList<Aminoacid> aminoacidItems = inventorySorterVisitor.getAminoacidItems();
                inventory.removeItem(aminoacidItems.get(aminoacidItems.size() - 1));
            }

            for (int i = 0; i < numberOfNucleoid; i++) {
                InventorySorterVisitor inventorySorterVisitor = VisitorManager.sortInventory(this);
                ArrayList<Nucleoid> nucleoidItems = inventorySorterVisitor.getNucleoidItems();
                inventory.removeItem(nucleoidItems.get(nucleoidItems.size() - 1));
            }

            inventory.addItem(r.addAgent());
            return;
        }
    }

    /**
     * Ágens felhasználása a virológus által
     *
     * @param v A célpont
     * @param a A felhasználni kívánt ágens
     */
    public void useAgent(Virologist v, Agent a) throws ItemNotFoundException {
        if (getParalyzed())
            return;
        getInventory().removeItem(a);
        a.use(this, v);
    }

    /**
     * Leszármazottak által definiálandó működés
     */
    public abstract void step();

    /**
     * Leszármazott általi döntés egy item felvételéről
     */
    public abstract void pickUp(IStorable s);
}
