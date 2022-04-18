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

public class SafeLaboratory extends Laboratory {
	
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

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}
	
	/* TODO Auto-generated method stub */
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
