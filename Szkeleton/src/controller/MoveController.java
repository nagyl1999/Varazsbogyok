package controller;

import game.Game;
import game.Tile;
import game.Vec2;
import graphics.VarazsbogyokFrame;
import entity.Virologist;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * A játékosok mozgásáért felelős kontroller
 */
public class MoveController extends Controller implements MouseListener {
    /**
     * Aktív kiválasztott mező
     */
    private Tile activeTile;
    private int counter = 0;
    private boolean canPickup = false;
    /**
     * Aktív tile vizsgálata, ha nincs kiválasztva egy se,
     * akkor hibát dobunk, egyébként léptetjük a virológust.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (activeTile == null) {
            VarazsbogyokFrame.getInstance().errorMessage("Please choose a tile");
            return;
        }

        try {
            if(Game.activeVirologist.getInventory().size() != Virologist.inventorySize)
                canPickup = VarazsbogyokFrame.getInstance().confirmDialog("Do you want to interact with this tile?");
            else {
                VarazsbogyokFrame.getInstance().errorMessage("Not enough inventory space!");
                canPickup = false;
            }
            Game.activeVirologist.move(activeTile, canPickup);
            VarazsbogyokFrame.getInstance().redraw();

        } catch (Exception e1) {
            VarazsbogyokFrame.getInstance().errorMessage("You can't move here");
        }
        VarazsbogyokFrame.getInstance().redraw();
    }

    /**
     * Kiválasztott mező beállítása
     *
     * @param e MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Tile clicked = null;

        for (Tile t : Game.map.getTiles()) {
            if (t == Game.activeVirologist.getTile())
                continue;
            if (t.contains(new Vec2((int)e.getPoint().getX(),(int)e.getPoint().getY()))) {
                clicked = t;
                break;
            }
        }
        

        if (clicked == null)
            return;
        if (!Game.activeVirologist.getTile().getNeighbours().contains(clicked))
            VarazsbogyokFrame.getInstance().errorMessage("Please choose a neighbour tile");
        activeTile = clicked;
        Color c = new Color(activeTile.getColor().getRed(),activeTile.getColor().getGreen(),activeTile.getColor().getBlue(),100);
        activeTile.setColor(c);
        VarazsbogyokFrame.getInstance().redraw();
        /*Color c2 = new Color(activeTile.getColor().getRed(),activeTile.getColor().getGreen(),activeTile.getColor().getBlue());
        activeTile.setColor(c2);*/
        // TODO - megjelenítés a térképen
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
