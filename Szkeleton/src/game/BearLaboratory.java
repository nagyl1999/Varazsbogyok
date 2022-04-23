package game;

import entity.Virologist;
import inventory.Inventory;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;
import item.Bear;

public class BearLaboratory extends Laboratory {

	public void interactedWith(Virologist v) throws NotEnoughSpaceException {
		try {
			Bear b = (Bear)inventory.at(0);
			b.use(null, v);
			inventory.removeItem(b);
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Inventory getInventory() {
		return inventory;
	}

	@Override
	public void fillInventory() throws NotEnoughSpaceException {
		while(inventory.hasSpace()) inventory.addItem(new Bear());
	}
}
