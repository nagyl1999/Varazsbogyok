package inventory;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : inventory.Inventory.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import java.util.ArrayList;

/** Készlet, amely játékon belül tárolható objektumok tárolásáért felel */
public class Inventory {
	/** Az inventory-ban elférő dolgok maximális száma */
	private int maxSize;
	/** Az inventory tulajdonosa */
	private IInventoryHolder owner;
	/** Tárolt objektumok */
	private ArrayList<IStorable> items;
	
	/** Tárolandó dolog hozzáfűzése a listához, amennyiben
	 * van elég hely */
	public void addItem(IStorable i) {
	}
	
	/** Tárolt dolog kivétele az inventory-ból */
	public void removeItem(IStorable i) {
	}
	
	/** Az inventory tartalmát feltérképező visitor fogadása */
	public void accept(IInventoryVisitor i) {
	}
}
