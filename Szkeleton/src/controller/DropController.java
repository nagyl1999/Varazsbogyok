package controller;

import game.Game;
import graphics.VarazsbogyokFrame;
import inventory.IStorable;

import java.awt.event.ActionEvent;

/**
 * Dolog eldobásáért felelős kontroller
 */
public class DropController extends Controller {

    /**
     * Lekérjük a kiválasztott dolgot, amennyiben null, hibát
     * dobunk, ha nem, akkor eldobjuk a "semmibe"
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO - hibakezelés
        IStorable s = VarazsbogyokFrame.getInstance().getActiveItem();
        if (s == null)
            return;

        try {
            Game.activeVirologist.getInventory().removeItem(s);
        } catch (Exception ignore) {
        }
    }
}
