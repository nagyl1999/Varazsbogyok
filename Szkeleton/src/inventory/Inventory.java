package inventory;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : inventory.Inventory.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/



/** */
public class Inventory {
	/** */
	private int maxSize;
	
	/** */
	private IStorable items;
	
	/** */
	private IInventoryHolder owner;
	
	/** */
	public void addItem(IStorable i) {
	}
	
	/** */
	public void removeItem(IStorable i) {
	}
	
	/** */
	public void accept(IInventoryVisitor i) {
	}
}