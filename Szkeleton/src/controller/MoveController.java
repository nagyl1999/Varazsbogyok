package controller;

import game.Game;
import game.Tile;
import graphics.VarazsbogyokFrame;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

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
        // TODO - hibakezelés
        if (activeTile == null) {
            //return;
        }

        //Game.activeVirologist.getTile().getxy();
        Game.activeVirologist.getApplied().clear();

        try {
            if(Game.activeVirologist.getInventory().size() != Game.activeVirologist.inventorySize)
                canPickup = VarazsbogyokFrame.getInstance().confirmDialog("Do you want to interact with this tile?");
            else {
                VarazsbogyokFrame.getInstance().errorMessage("Not enough inventory space!");
                canPickup = false;
            }
            Game.activeVirologist.move(Game.map.getTiles().get(counter++), canPickup);

            //Game.activeVirologist.getTile().setColor(Color.PINK);
            VarazsbogyokFrame.getInstance().redraw();

        } catch (Exception e1) {
            VarazsbogyokFrame.getInstance().errorMessage("Ide nem léphetsz tesó....");
        }
    }

    /**
     * Kiválasztott mező beállítása
     *
     * @param e MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO - mező kiválasztása
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
