package entity;

import java.util.ArrayList;
import java.util.Random;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : entity.Bot.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import game.Game;
import game.Tile;
import game.Timer;
import inventory.IStorable;
import inventory.Inventory;
import inventory.InventorySorterVisitor;
import inventory.VisitorManager;
import item.Agent;
import graphics.VarazsbogyokFrame;

/**
 * A Bot döntéseit megvalósító osztály
 */
public class Bot extends Virologist {
    /**
     * Ikon elérési út
     */
    protected String iconPath = "resources\\bot.jpg";
    
    private static Random r = new Random();
    
    /**
     * A Bot lépését szimuláló függvény
     */
    public void step() {
        VarazsbogyokFrame.getInstance().setDisabled(true);
        Game.activeVirologist = this;

		try {

			Inventory iv = getInventory();
			for (int i = 0; i < 100; i++) {
				InventorySorterVisitor isv = new InventorySorterVisitor();
				iv.accept(isv);
				switch (r.nextInt(10)) {
					case 0:
						try {
							useGear(isv.getAxeItems().get(0), tile.getVirologist().get(r.nextInt(tile.getVirologist().size())));
						} catch (Exception ex) {
							//ex.printStackTrace();
						}
						break;
					case 1:
						ArrayList<Tile> ng = tile.getNeighbours();
						try {
							move(ng.get(r.nextInt(ng.size())), true);
						} catch (Exception ex) {
							try {
								move(ng.get(r.nextInt(ng.size())), false);
							} catch (Exception exx) {

							}
							//ex.printStackTrace();
						}
						break;
					case 2:
						try {
							Virologist vv = tile.getVirologist().get(r.nextInt(tile.getVirologist().size()));
							if (vv != this) {
								this.useAgent(vv, isv.getDancerItems().get(0));
							}
						} catch (Exception ex) {

						}
					case 3:
						try {
							Virologist vv = tile.getVirologist().get(r.nextInt(tile.getVirologist().size()));
							if (vv != this) {
								this.useAgent(vv, isv.getParalyzerItems().get(0));
							}
						} catch (Exception ex) {

						}
					case 4:
						try {
							Virologist vv = tile.getVirologist().get(r.nextInt(tile.getVirologist().size()));
							if (vv != this) {
								this.useAgent(vv, isv.getForgetterItems().get(0));
							}
						} catch (Exception ex) {

						}
					case 5:
						try {
							Virologist vv = tile.getVirologist().get(r.nextInt(tile.getVirologist().size()));
							if (vv != this) {
								this.useAgent(vv, isv.getForgetterItems().get(0));
							}
						} catch (Exception ex) {

						}
					case 6:
						try {
							this.makeAgent(isv.getRdancerItems().get(0));
						} catch (Exception ex) {
						}
					case 7:
						try {
							this.makeAgent(isv.getRforgetterItems().get(0));
						} catch (Exception ex) {

						}
					case 8:
						try {
							this.makeAgent(isv.getRpalaryzerItems().get(0));
						} catch (Exception ex) {

						}
					case 9:
						try {
							this.makeAgent(isv.getRprotectorItems().get(0));
						} catch (Exception ex) {

						}
				}
			}
			for (Agent a : applied)
				try {
					a.effect(this);
				} catch (Exception ignore) {
				}
		} catch (Exception ignore) {
		} finally {
			Game.timer.tick();
		}
    }

    /**
     * A Bot egy item felvételéről dönt
     */
    public void pickUp(IStorable s) {
        if (VisitorManager.hasBear(this) || VisitorManager.hasDancer(this) || VisitorManager.hasParalyzer(this))
            return;
        try {
            tile.interactedWith(this);
        } catch (Exception ignored) {
        }
    }

    /**
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * A bot meghal, így kitörlődik mindennel együtt a pályáról
     */
    public void die() {
        tile.removeVirologist(this);
        // TODO - steppable-k közül kiszedni (?)
    }

}
