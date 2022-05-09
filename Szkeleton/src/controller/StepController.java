package controller;

import game.Timer;

import java.awt.event.ActionEvent;

/**
 * Körlépésért felelős kontroller
 */
public class StepController extends Controller {

    /**
     * Kör léptetése
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Timer.getInstance().tick();
    }
}
