package com.company;

/** Airbus repülő */
public class Airbus extends Plane {

    /** Konstruktor */
    public Airbus(String fid) {
        super(fid);
    }

    /** Látogató fogadása */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }
}
