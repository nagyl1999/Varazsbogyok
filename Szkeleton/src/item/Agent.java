package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Agent.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;
import inventory.IStorable;

/** A játékban található ágensek őosztálya. A virológusok ezeket használhatják fel egymás gyengítése illetve
 * saját maguk megsegítése céljából.
 * */
public abstract class Agent implements  IStorable, Steppable {
	/** Az ágens elbomlásáig visszamaradt idő. */
	protected int expire;
	/**A virológusra van felkenve az ágens. */
	private Virologist virologist;
	
	/** A paraméterben kapott virológuson hajtja végre a hatást.*/
	public abstract void effect(Virologist v);
	
	/** Egyel csökkenti az expire értékét.*/
	public abstract void decompose(Virologist v);
	
	/** A protector ágens fogja megvédeni a virológust.  */
	public abstract void protect(Virologist v, Agent a);
	
	/** Melyik virológus fog felkenni a másikra ágenst
	 * @param v1 Felkenő virológus
	 * @param v2 Elszenvedő virológus
	 * */
	public abstract void use(Virologist v1, Virologist v2);
	/** Az ágens léptetését szimuláló fügvény. */
	public abstract void step();
	/** A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni az ágens típust. */
	public abstract void accept(IInventoryVisitor i);
}