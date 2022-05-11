package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Referenciákat tároló gombok
 */
public class ReferenceButton extends JButton {
    /**
     * Objektumreferencia
     */
    private IIcon reference;

    /**
     * Konstruktor
     */
    public ReferenceButton(IIcon r) {
        super();
        reference = r;
        init();
    }

    /**
     * Grafikai elemek beállítása
     */
    private void init() {
        setPreferredSize(new Dimension(50, 50));
        setIcon(new ImageIcon(reference.getIconPath()));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Setter - reference
     */
    public void setReference(IIcon r) {
        reference = r;
        init();
    }

    /**
     * Getter - reference
     */
    public Object getReference() {
        return reference;
    }
}
