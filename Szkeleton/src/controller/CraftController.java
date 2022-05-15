package controller;

import game.Game;
import graphics.VarazsbogyokFrame;
import item.Recipe;

import java.awt.event.ActionEvent;

/**
 * Kraftolásért felelős kontroller
 */
public class CraftController extends Controller {

    /**
     * Aktív virológus lekérése, amennyiben nincs
     * kiválasztva hibát dobunk, egyébként kraftolás
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO - hibakeresés, rossz típusra kattintás
        try{
            Recipe r = (Recipe) VarazsbogyokFrame.getInstance().getActiveItem();

            if (r == null)
                return;

            try {
                Game.activeVirologist.makeAgent(r);
            } catch (Exception ignore) {

            }
        }catch (Exception valami){
            VarazsbogyokFrame.getInstance().errorMessage("Please choose a recipe");
        }

    }
}
