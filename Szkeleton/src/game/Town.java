package game;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : game.Town.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;

/** Város mező, általános célú terep, nincs
 * konkrét funkciója */
public class Town extends Tile {

	/** A virológus így nézi meg, hogy mi található a mezőn */
	public void interactedWith(Virologist v) {
		System.out.println("Town.interactedWith");
	}
	
	/** Egy virológus fogadása a mezőre */
	public void acceptVirologist(Virologist v) {
		//TODO
	}
}
