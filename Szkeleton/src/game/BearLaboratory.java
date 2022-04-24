package game;

import entity.Virologist;
import inventory.Inventory;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;
import item.Bear;
/**A játékban megtalálható medve laboratórium. Itt tud a virológ megfertőződni medve vírussal,*/
public class BearLaboratory extends Laboratory {
	
	/**A medvevírus itt kenődik fel a virológusra. Kivédhető ha a virológuson köpeny van, vagy védelmező ágens*/
	public void interactedWith(Virologist v) throws NotEnoughSpaceException {
		try {
			Bear b = (Bear)inventory.at(0);
			b.use(null, v);
			inventory.removeItem(b);
		} catch (ItemNotFoundException e) {
			e.printStackTrace();}
	}
	
	/**Visszaadja  amező inventoryját.*/
	@Override
	public Inventory getInventory() {
		return inventory;
	}
	
	/**A mező inventoryjának feltöltése medve vírussal.*/
	@Override
	public void fillInventory() throws NotEnoughSpaceException {
		while(inventory.hasSpace()) inventory.addItem(new Bear());
	}
}
