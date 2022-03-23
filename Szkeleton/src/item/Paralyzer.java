package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Paralyzer.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;
import item.Agent;

/**Bénulást okozó ágens */
public class Paralyzer extends Agent {
	/**A bénulás ágens léptetését szimuláló fügvény. */
	public void step() {
	}
	
	/**A függvény paraméterben kapott virológuson fogja kifejteni a hatását az ágens. */
	public void effect(Virologist v) {
	}
	
	/**A függvény paraméterben kapott virológuson szünteti meg a felkent ágens hatását. */
	public void decompose(Virologist v) {
	}
	
	/**A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a bénító ágens típust.  */
	public void accept(IInventoryVisitor i) {
	}
	
	/**Az ágens vírus típusú, így nincs védő hatása. */
	public void protect(Virologist v, Agent a) {
	}
	
	/**Az ágens felhasználására irányuló függvény.
	 * @param v1 A felhasználó
	 * @param v2 Az elszenvedő
	 * */
	public void use(Virologist v1, Virologist v2) {
	}

}
