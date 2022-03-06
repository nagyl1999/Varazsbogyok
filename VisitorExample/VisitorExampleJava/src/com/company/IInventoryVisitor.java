package com.company;

/** Látogató interfész */
public interface IInventoryVisitor {
    /** Ford típus fogadása */
    public void visit(Ford i);
    /** Toyota típus fogadása */
    public void visit(Toyota i);
    /** Boeing típus fogadása */
    public void visit(Boeing i);
    /** Airbus típus fogadása */
    public void visit(Airbus i);
}
