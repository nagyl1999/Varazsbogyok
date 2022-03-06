package com.company;

/** Repülők közös őse */
public abstract class Plane implements IStorable {
    /** Azonosító */
    protected String flightId;

    /** Konstruktor */
    public Plane(String fid) {
        flightId = fid;
    }

    /** Absztrakt, őt nem lehet meglátogatni */
    public abstract void accept(IInventoryVisitor i);
}
