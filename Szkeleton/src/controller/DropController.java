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
        try {
            IStorable s = VarazsbogyokFrame.getInstance().getActiveItem();
            if (s == null){
                VarazsbogyokFrame.getInstance().errorMessage("Pleae choose something");
                return;
            }

            try {
                Game.activeVirologist.getInventory().removeItem(s);
                VarazsbogyokFrame.getInstance().redraw();
                VarazsbogyokFrame.getInstance().setActiveItem(null);
            } catch (Exception ignore) {
            }
        }catch (Exception valami){
            VarazsbogyokFrame.getInstance().errorMessage("You can't drop this");
        }


    }
}
