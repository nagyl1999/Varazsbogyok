package graphics;

import game.Game;
import game.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

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
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener((MouseListener) GamePanel.mc);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Tile t : Game.map.getTiles()) {
            g.setColor(t.getColor());
            g.drawPolygon(t.getPolygon());
            g.fillPolygon(t.getPolygon());
           
        }
        g.setColor(Color.BLACK);
        g.drawPolygon(Game.activeVirologist.getTile().getCircle());
        g.fillPolygon(Game.activeVirologist.getTile().getCircle());
        
    }

}
