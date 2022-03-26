package inventory;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : inventory.Inventory.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Készlet, amely játékon belül tárolható objektumok tárolásáért felel
 */
public class Inventory implements Iterator<IStorable> {
    /**
     * Az inventory-ban elférő dolgok maximális száma
     */
    private int maxSize;
    /**
     * Az inventory tulajdonosa
     */
    private IInventoryHolder owner;
    /**
     * Tárolt objektumok
     */
    private ArrayList<IStorable> items;

    /**
     * Konstruktor
     */
    public Inventory(int size) {
        maxSize = size;
        items = new ArrayList<>();
    }

    /**
     * Inventory jelenlegi mérete
     */
    public int size() {
        return items.size();
    }

    /**
     * Van-e hely az inventory-ban
     */
    public boolean hasSpace() {
        return size() < maxSize;
    }

    /**
     * Tárolandó dolog hozzáfűzése a listához, amennyiben
     * van elég hely
     */
    public void addItem(IStorable i) throws NotEnoughSpaceException {
        // TODO - jelenleg nem tudunk a zsák inventory-jába rakni, lehet visitor intézze
        if (!hasSpace())
            throw new NotEnoughSpaceException("Nincs elég hely!");
        items.add(i);
    }

    /**
     * Tárolt dolog kivétele az inventory-ból
     */
    public void removeItem(IStorable i) throws ItemNotFoundException {
        if (!items.contains(i))
            throw new ItemNotFoundException("Az objektum nem található az inventory-ban!");
        items.remove(i);
    }

    /**
     * Az inventory tartalmát feltérképező visitor fogadása
     */
    public void accept(IInventoryVisitor i) {
        for (IStorable item : items) {
            item.accept(i);
        }
    }

    //region Iterator

    /**
     * Ciklus pozíció
     */
    private int pos = 0;

    /**
     * Ciklus nullázása
     */
    public void reset() {
        pos = 0;
    }

    /**
     * Jelenlegi pozíció kisebb-e mint az inventory-ban található elemek száma
     */
    @Override
    public boolean hasNext() {
        return pos < size() - 1;
    }

    /**
     * Jelenlegi posíción lévő objektum visszaadása
     */
    @Override
    public IStorable next() {
        return items.get(pos++);
    }

    //endregion

}
