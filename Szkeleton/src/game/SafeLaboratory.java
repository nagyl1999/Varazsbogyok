package game;

import java.util.Random;

import entity.Virologist;
import inventory.Inventory;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;
import item.Agent;
import item.RDancer;
import item.RForgetter;
import item.RParalyzer;
import item.RProtector;
import item.Recipe;
/**A játékbna a biztonságos laboratórium, itt tud a virológus recepteket felvenni.*/
public class SafeLaboratory extends Laboratory {
	/**Itt adjuk hozzá a virológus inventoryjához a felvenni kivánt receptet.*/
	public void interactedWith(Virologist v) throws NotEnoughSpaceException {
		try {
			Recipe r = (Recipe) inventory.at(0);
			v.getInventory().addItem(r);
			inventory.removeItem(r);
		} catch (NotEnoughSpaceException e) {
			e.printStackTrace();
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**Visszaadja a mező inventoryját.*/
	@Override
	public Inventory getInventory() {
		return inventory;
	}
	
	/**Itt töltjük meg a mező inventoryját véletlenszerű receptekkel.*/
	@Override
	public void fillInventory() throws NotEnoughSpaceException {
		Random r = new Random();
		while(inventory.hasSpace()) {
			int n = r.nextInt(3);
			switch (n) {
				case 0:
					inventory.addItem(new RDancer());
					break;
				case 1:
					inventory.addItem(new RForgetter());
					break;
				case 2:
					inventory.addItem(new RParalyzer());
					break;
				default:
					inventory.addItem(new RProtector());
			}
		}
	}
}
