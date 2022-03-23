package com.company;

/** Ford autó */
public class Ford extends Car {

    /** Konstruktor */
    public Ford(String lpn) {
        super(lpn);
    }

    /** Látogató fogadása */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

}
