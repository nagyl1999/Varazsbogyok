package controller;

import game.Game;
import game.Tile;
import graphics.VarazsbogyokFrame;
import entity.Virologist;

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
            if(Game.activeVirologist.getInventory().size() != Game.activeVirologist.inventorySize)
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
            if (t.getPolygon().contains(e.getPoint())) {
                clicked = t;
                break;
            }
        }
        System.out.println(clicked); // TODO - kiszedni

        if (clicked == null)
            return;
        if (!Game.activeVirologist.getTile().getNeighbours().contains(clicked))
            VarazsbogyokFrame.getInstance().errorMessage("Please choose a neighbour tile");
        activeTile = clicked;
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
