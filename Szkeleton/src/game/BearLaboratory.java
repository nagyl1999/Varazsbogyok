package game;

import entity.Virologist;
import inventory.Inventory;
import inventory.NotEnoughSpaceException;
import item.Bear;

public class BearLaboratory extends Laboratory {

	public void interactedWith(Virologist v) throws NotEnoughSpaceException {
		// TODO Auto-generated method stub
	}

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return inventory;
	}

	@Override
	public void fillInventory() throws NotEnoughSpaceException {
		for(int i=0;i<inventory.size();i++) inventory.addItem(new Bear());
		// TODO Auto-generated method stub
		
	}
	
	

}
