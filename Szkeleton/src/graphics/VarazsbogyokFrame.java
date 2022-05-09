package graphics;

import javax.swing.*;

/**
 * Megjeleníthető ablak
 */
public class VarazsbogyokFrame extends JFrame {
    /**
     * Map panel
     */
    JPanel map;

    /**
     * Konstruktor
     */
    public VarazsbogyokFrame() {
        init();
    }

    /**
     * Komponsensek létrehozása
     */
    public void init() {
        map = new JPanel();
    }

}
