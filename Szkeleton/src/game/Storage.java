package game;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : game.Storage.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import inventory.Inventory;
import inventory.ItemNotFoundException;
import inventory.NotEnoughSpaceException;
import item.*;
import java.util.Random;

/** Raktár mező, a rálépő virológusnak egy
 * véletlenszerű anyagot kínál fel */

public class Storage extends Tile {

	/** Itt addjuk hozzá a virológus inventoryjához a felvenni kivánt anyagot.*/
	public void interactedWith(Virologist v) throws NotEnoughSpaceException {
		try {
			Material m = (Material) inventory.at(0);
			v.getInventory().addItem(m);
			inventory.removeItem(m);
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
	
	/**Itt töltjük meg a mező inventoryját véletlenszerű anyagokkal.*/
	@Override
	public void fillInventory() throws NotEnoughSpaceException {
		Random r = new Random();
		while(inventory.hasSpace()) {
		int n = r.nextInt(2);
		if(n == 0)inventory.addItem(new Aminoacid());
		if(n == 1)inventory.addItem(new Nucleoid());
		}
	}
}
