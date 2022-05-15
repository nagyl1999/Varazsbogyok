package controller;

import game.Game;
import graphics.VarazsbogyokFrame;
import inventory.IStorable;
import inventory.VisitorManager;
import item.Bag;

import java.awt.event.ActionEvent;

/**
 * Zsákon végzendő műveletek
 */
public class BagController extends Controller {

    /**
     * Zsákba való betétel, vagy abból kivétel
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Bag b = VisitorManager.getBag(Game.activeVirologist);
        if (b == null) {
            VarazsbogyokFrame.getInstance().errorMessage("No bag found");
            return;
        }

        IStorable item = VarazsbogyokFrame.getInstance().getActiveItem();
        if (item == null) {
            VarazsbogyokFrame.getInstance().errorMessage("No item selected");
            return;
        }

        if (item == b) {
            VarazsbogyokFrame.getInstance().errorMessage("No bag in bag");
            return;
        }

        try {
            /* Táskából inventoryba */
            if (b.getInventory().contains(item)) {
                if (Game.activeVirologist.getInventory().hasSpace()) {
                    System.out.println("1");
                    b.getInventory().removeItem(item);
                    Game.activeVirologist.getInventory().addItem(item);
                    return;
                }else VarazsbogyokFrame.getInstance().errorMessage("No space left to move item");
            }

            /* Inventoryból táskába */
            if (Game.activeVirologist.getInventory().contains(item)) {
                if (b.getInventory().hasSpace()) {
                    System.out.println("2");
                    Game.activeVirologist.getInventory().removeItem(item);
                    b.getInventory().addItem(item);
                    return;
                }else VarazsbogyokFrame.getInstance().errorMessage("No space left to move item");
            }
        }catch (Exception ignore) {
            VarazsbogyokFrame.getInstance().errorMessage(ignore.getMessage());
        }finally {
            VarazsbogyokFrame.getInstance().redraw();
        }
    }
}
