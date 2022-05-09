package graphics;

import java.awt.*;

/**
 * A pályán kirajzolható dolgok összefoglaló
 * interfésze, tartalmaznia kell egy színt, és
 * két koordinátát.
 */
public interface IDrawable {
    /**
     * X koordináta lekérése
     */
    public int getX();

    /**
     * Y koordináta lekérése
     */
    public int getY();

    /**
     * Az alakzathoz tartozó szín lekérése
     */
    public Color getColor();

    /**
     * Az alakzat lekérése
     */
    public Polygon getPolygon();
}
