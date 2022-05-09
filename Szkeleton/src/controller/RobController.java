package controller;

import entity.Virologist;
import game.Game;
import graphics.VarazsbogyokFrame;

import java.awt.event.ActionEvent;

/**
 * Játékos kirablásáért felelős kontroller
 */
public class RobController extends Controller {

    /**
     * Aktív virológus keresése, ha null, akkor hibát dobunk
     * egyébként kiraboljuk.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO - hibakezelés
        Virologist v = VarazsbogyokFrame.getInstance().getActiveVirologist();
        if (v == null)
            return;

        try {
            Game.activeVirologist.robVirologist(v);
        } catch (Exception ignore) {
        }

    }
}
