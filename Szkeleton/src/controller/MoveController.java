package controller;

import game.Game;
import game.Tile;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * A játékosok mozgásáért felelős kontroller
 */
public class MoveController extends Controller implements MouseListener {
    /**
     * Aktív kiválasztott mező
     */
    private Tile activeTile;

    /**
     * Aktív tile vizsgálata, ha nincs kiválasztva egy se,
     * akkor hibát dobunk, egyébként léptetjük a virológust.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO - hibakezelés
        if (activeTile == null)
            return;
        try {
            Game.activeVirologist.move(activeTile);
        } catch (Exception ignore) {
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
