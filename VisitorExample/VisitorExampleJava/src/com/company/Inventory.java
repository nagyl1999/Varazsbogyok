package com.company;

import java.util.ArrayList;

/** Inventory osztály */
public class Inventory {
    /** IStorable-ként tárolt cuccok */
    private ArrayList<IStorable> items;

    /** Konstruktor */
    public Inventory() {
        items = new ArrayList<>();
    }

    public ArrayList<IStorable> getInventory() {
        return items;
    }

    /** Hozzáadás, fontos, hogy itt már IStorableként
     * vesszük át az adott objektumot, függetlenül
     * attól, hogy eredetileg miként lett létrehozva */
    public void add(IStorable i) {
        items.add(i);
    }

    /** Látogató fogadása */
    public void accept(IInventoryVisitor i) {
        for(IStorable s : items) {
            s.accept(i);
        }
    }
}
