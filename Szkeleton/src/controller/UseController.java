package controller;

import entity.Virologist;
import game.Game;
import graphics.VarazsbogyokFrame;
import inventory.IStorable;
import item.IUsable;

import java.awt.event.ActionEvent;

/**
 * Dolog használatáért felelős kontroller
 */
public class UseController extends Controller {

    /**
     * Aktív virológus, és dolog vizsgálata, ha van null
     * akkor hibát dobunk, egyébként pedig használjuk a
     * kiválasztott dolgokat.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO - hibakezelés
        Virologist v = VarazsbogyokFrame.getInstance().getActiveVirologist();
        IUsable s = (IUsable) VarazsbogyokFrame.getInstance().getActiveItem();

        if (v == null){
            VarazsbogyokFrame.getInstance().errorMessage("Please choose a virologist");
            return;
        }else if(s == null){
            VarazsbogyokFrame.getInstance().errorMessage("Please choose an item");
            return;
        }

        try {
            Game.activeVirologist.use(v, s);
        } catch (Exception ignore) {
        }

        VarazsbogyokFrame.getInstance().redraw();
    }
}
