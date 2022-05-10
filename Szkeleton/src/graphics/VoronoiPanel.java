package graphics;

import game.Game;
import game.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * Voronoi csempézett játéktér megjelentése
 */
public class VoronoiPanel extends JPanel {

    public VoronoiPanel() {
        super(new FlowLayout());
        init();
    }

    public void init() {
        setPreferredSize(new Dimension(500, 800));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Tile t : Game.map.getTiles()) {
            g.setColor(t.getColor());
            g.drawPolygon(t.getPolygon());
            g.fillPolygon(t.getPolygon());
        }
    }

}
