package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.RDancer.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;
import inventory.InventorySorterVisitor;

/** A vitustáncot okozó ágens receptje.*/
public class RDancer extends Recipe {
	/** A visitor tervezési mintát kihasználva a visitor megnézi, hogy a vitus táncot okozó ágens recepjéhez van-e
	 elegendő alapanyag. */
	public boolean hasEnoughMaterial(InventorySorterVisitor i) {
		return true;
	}
	
	/** A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a vitustánc ágens receptje típust. */
	public void accept(IInventoryVisitor i) {
	}
	

}
