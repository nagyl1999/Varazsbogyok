package com.company;

/** Tárolható dolgok interfésze */
public interface IStorable {
    /** Látogatást biztosító metódus */
    public void accept(IInventoryVisitor i);
}
