package com.company;

/** Boeing repülő */
public class Boeing extends Plane {

    /** Konstruktor */
    public Boeing(String fid) {
        super(fid);
    }

    /** Látogató fogadása */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }
}
