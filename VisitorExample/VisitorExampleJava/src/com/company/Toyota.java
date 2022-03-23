package com.company;

public class Toyota extends Car {

    /** Konstruktor */
    public Toyota(String lpn) {
        super(lpn);
    }

    /** Látogató fogadása */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }
}
