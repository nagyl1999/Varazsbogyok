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
        if (v == null){
            VarazsbogyokFrame.getInstance().errorMessage("Nincs kiválasztva virologus tesó....");
            return;
        }else if(v == Game.activeVirologist){
            VarazsbogyokFrame.getInstance().errorMessage("Magadat nem tudod kirabolni tesó....");
            return;
        }

        try {
            Game.activeVirologist.robVirologist(v);
            VarazsbogyokFrame.getInstance().redraw();
        } catch (Exception e1) {
            VarazsbogyokFrame.getInstance().errorMessage("Nem tudsz lopni tesó....");
        }

    }
}
