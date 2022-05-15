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
import graphics.IIcon;
import inventory.*;
import item.*;
import item.AgentComparator;
import entity.Virologist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Egy közös entitás működését szimuláló osztály
 */
public abstract class Virologist implements Steppable, IInventoryHolder , Serializable, IIcon {
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
     * Inventory méret
     */
    public static int inventorySize = 10;

    /**
     * Konstruktor
     */
    public Virologist() {
        inventory = new Inventory(this, Virologist.inventorySize);
        applied = new ArrayList<>();
        paralyzed = false;
    }

    /**
     * Getter - Ikon elérési út
     */
    public abstract String getIconPath();

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
     * Getter - Mező
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * Setter - Mező
     */
    public void setTile(Tile t) {
        tile = t;
    }

    /**
     * Felszerelés használata más virológuson
     *
     * @param g A felhasznált felszerelés
     * @param v A megtámadott virológus
     * @throws StateDoesNotAllowActionException
     */
    @Deprecated
    public void useGear(Gear g, Virologist v) throws StateDoesNotAllowActionException {
        if (VisitorManager.hasBear(this) ||VisitorManager.hasDancer(this) ||VisitorManager.hasParalyzer(this))
            throw new StateDoesNotAllowActionException("Virologist is not allowed to take action");
        g.use(this, v);
    }

    /**
     * Ágens felkenése a virológusra, ágensek rendezése a konzisztens
     * állapot fenttartása érdekében, mielőtt
     *
     * @param v Virológus aki felkeni az ágenst
     * @param a Agéns amit felkennek
     */
    public void applyAgent(Virologist v, Agent a) throws ItemNotFoundException {
        applied.add(a);
        for (Gear g : VisitorManager.getGear(this))
            g.protect(this, v, a);
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
     * @throws StateDoesNotAllowActionException
     */
    public void move(Tile t, boolean interact) throws NotEnoughSpaceException, StateDoesNotAllowActionException {
        if (VisitorManager.hasBear(this) ||VisitorManager.hasDancer(this) ||VisitorManager.hasParalyzer(this)) {
            throw new StateDoesNotAllowActionException("Virologist is not allowed to take action");
        }
        if (!tile.getNeighbours().contains(t)) {
            throw new StateDoesNotAllowActionException("Not neighbouring tiles");
        }
        tile.removeVirologist(this);
        t.addVirologist(this);
        if(interact)
            t.interactedWith(this);
    }

    /**
     * Egy másik virológus kirablása
     * @throws StateDoesNotAllowActionException
     * @throws ItemNotFoundException
     */
    public void robVirologist(Virologist v) throws StateDoesNotAllowActionException, ItemNotFoundException {
        if (VisitorManager.hasBear(this) ||VisitorManager.hasDancer(this) ||VisitorManager.hasParalyzer(this))
            throw new StateDoesNotAllowActionException("Virologist is not allowed to take action");
        if (!VisitorManager.hasParalyzer(v))
            throw new StateDoesNotAllowActionException("Virologist to be robbed is not paralyzed");
        if (tile != v.getTile())
            throw new StateDoesNotAllowActionException("Virologists are not on the same tile");
        for (IStorable i : VisitorManager.getStealable(v)) {
            try {
                getInventory().addItem(i);
                v.getInventory().removeItem(i);
            } catch (NotEnoughSpaceException n) {
                return; // Elfogyott a hely a mi inventory-nkban
            }
        }
    }

    /**
     * Egy ágens recept alapján való létrehozása
     * @throws StateDoesNotAllowActionException
     */
    public void makeAgent(Recipe r) throws ItemNotFoundException, NotEnoughSpaceException, StateDoesNotAllowActionException {
        if (VisitorManager.hasBear(this) ||VisitorManager.hasDancer(this) ||VisitorManager.hasParalyzer(this))
            throw new StateDoesNotAllowActionException("Virologist is not allowed to take action");
        if (!VisitorManager.craftRecipe(this, r))
            throw new StateDoesNotAllowActionException("Virologist does not have enough material");
        InventorySorterVisitor i = VisitorManager.sortInventory(this);
        for (int j = 0; j < r.getNumberOfAminoacid(); j++) {
            inventory.removeItem(i.getAminoacidItems().get(j));
        }
        for (int j = 0; j < r.getNumberOfNucleoid(); j++) {
            inventory.removeItem(i.getNucleoidItems().get(j));
        }
        inventory.addItem(r.addAgent());
    }

    /**
     * Ágens felhasználása a virológus által
     *
     * @param v A célpont
     * @param a A felhasználni kívánt ágens
     * @throws StateDoesNotAllowActionException
     */
    @Deprecated
    public void useAgent(Virologist v, Agent a) throws ItemNotFoundException, StateDoesNotAllowActionException {
        if (VisitorManager.hasBear(this) ||VisitorManager.hasDancer(this) ||VisitorManager.hasParalyzer(this))
            throw new StateDoesNotAllowActionException("Virologist is not allowed to take action");
        getInventory().removeItem(a);
        a.use(this, v);
    }

    /**
     * Használható dolog felhasználása
     *
     * @param v A célpont
     * @param i A felhasználni kívánt dolog
     */
    public void use(Virologist v, IUsable i) throws StateDoesNotAllowActionException, ItemNotFoundException {
        if (VisitorManager.hasBear(this) ||VisitorManager.hasDancer(this) ||VisitorManager.hasParalyzer(this))
            throw new StateDoesNotAllowActionException("Virologist is not allowed to take action");
        i.use(this, v);
    }

    /**
     * A virológus meghal
     */
    public abstract void die();

    /**
     * Leszármazottak által definiálandó működés
     */
    public abstract void step();

    /**
     * Leszármazott általi döntés egy item felvételéről
     */
    public abstract void pickUp(IStorable s);
}
