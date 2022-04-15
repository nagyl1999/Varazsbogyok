package game;

import java.util.Random;

import entity.Virologist;
import inventory.Inventory;
import inventory.NotEnoughSpaceException;
import item.RDancer;
import item.RForgetter;
import item.RParalyzer;
import item.RProtector;

public class SafeLaboratory extends Laboratory {
	
	public void interactedWith(Virologist v) throws NotEnoughSpaceException {
		System.out.println("Laboratory.interactedWith");
		System.out.println("i.addItem");
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
		for(int i=0;i<inventory.size();i++) {
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
