package com.company;

/** Autók közös őse */
public abstract class Car implements IStorable {
    /** Rendszám */
    protected String licensePlateNumber;

    /** Konstruktor */
    public Car(String lpn) {
        licensePlateNumber = lpn;
    }

    /** Absztrakt, őt nem lehet meglátogatni */
    public abstract void accept(IInventoryVisitor i);
}
