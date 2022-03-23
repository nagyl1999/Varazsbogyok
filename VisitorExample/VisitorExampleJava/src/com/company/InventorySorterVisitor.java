package com.company;

import java.util.ArrayList;

/** Visitor osztály */
public class InventorySorterVisitor implements IInventoryVisitor {
    /** Fordokat tároló lista */
    public ArrayList<Ford> ford;
    /** Airbusokat tároló lista */
    public ArrayList<Airbus> airbus;
    /** Boeingeket tároló lista */
    public ArrayList<Boeing> boeing;
    /** Toyotákat tároló lista */
    public ArrayList<Toyota> toyota;

    public InventorySorterVisitor() {
        ford = new ArrayList<>();
        airbus = new ArrayList<>();
        boeing = new ArrayList<>();
        toyota = new ArrayList<>();
    }

    /** Fordokat fogadó metódus */
    public void visit(Ford i) {
        ford.add(i);
    }

    /** Airbusokat fogadó metódus */
    public void visit(Airbus i) {
        airbus.add(i);
    }

    /** Boeingeket fogadó metódus */
    public void visit(Boeing i) {
        boeing.add(i);
    }

    /** Toyotákat fogadó metódus */
    public void visit(Toyota i) {
        toyota.add(i);
    }

}
