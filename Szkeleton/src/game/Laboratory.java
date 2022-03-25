package game;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : game.Laboratory.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;
import item.*;
import java.util.Random;

/** Laboratórium mező, rálépéskor egy receptet kínál
 * fel a virológus számára
 * */
public class Laboratory extends Tile {

	/** Itt generálunk egy véletlenszerű receptet. */
	public void interactedWith(Virologist v) {
		Random r = new Random();
		int n = r.nextInt(3);
		switch (n) {
			case 0:
				RDancer dancer = new RDancer();
				break;
			case 1:
				RForgetter forgetter = new RForgetter();
			case 2:
				RParalyzer paralyzer = new RParalyzer();
			default:
				RProtector protector = new RProtector();
		}
	}

		/**
		 * Egy virológus fogadása a mezőre, itt felkínálunk
		 * neki egy véletlenszerű receptet
		 */
		public void acceptVirologist (Virologist v){
		//TODO
		}


}
