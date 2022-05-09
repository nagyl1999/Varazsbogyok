package controller;

import graphics.VarazsbogyokFrame;

import java.awt.event.ActionListener;

/**
 * A grafikus felületet vezérlő kontrollereket
 * összefoglaló absztrakt ősosztály
 */
public abstract class Controller implements ActionListener {
    /**
     * A képernyőfrissítést vegző metódus
     */
    protected void redraw() {
        VarazsbogyokFrame.getInstance().redraw();
    }
}
