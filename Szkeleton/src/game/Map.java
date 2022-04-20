package game;

import java.io.Serializable;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : game.Map.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import java.util.ArrayList;

/** Pálya objektum, a mezőket és a léptethető
 * objektumokat tartalmazza
 * */
public class Map implements Serializable {
	/** A pályán lévő mezők */
	private ArrayList<Tile> tiles;
	/** A pályán lévő léptethető objektumok */
	private Timer timer;

	/** Konstruktor */
	public Map(){
		tiles = new ArrayList<Tile>();
		timer = timer.getInstance();
	}
	
	/** Mező hozzáadása a páylához */
	public void addTile(Tile t) {
		tiles.add(t);
	}

	/** Timer hozzáadása a páylához */
	public void setTimer(Timer t){
		timer = t;
	}

	/** Visszaadja a pálya mezőit. */
	public ArrayList<Tile> getTiles(){
		return tiles;
	}

}
