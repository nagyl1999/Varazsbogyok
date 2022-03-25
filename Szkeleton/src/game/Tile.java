package game;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : game.Tile.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import entity.Virologist;

import java.util.ArrayList;

/** Mező ősosztály */
public abstract class Tile {
	/** A mezőn tartózkodó virológusok */
	protected ArrayList<Virologist> virologists;
	/** A mező szomszédai */
	protected ArrayList<Tile> neighbours;

	/** Getter - szomszédok */
	public ArrayList<Tile> getNeighbours() {
		return neighbours;
	}

	/** Getter - virológusok */
	public ArrayList<Virologist> getVirologist() {
		return virologists;
	}

	/** Virológus hozzáadása a mezőhöz */
	public void addVirologist(Virologist v) {
		virologists.add(v);
	}
	
	/** Virológus törlése a mezőről */
	public void removeVirologist(Virologist v) {
		virologists.remove(v);
	}
	
	/** Szomszéd hozzáadása */
	public void addNeighbour(Tile t) {
		neighbours.add(t);
	}
	
	/** A virológus így nézi meg, hogy mi található a mezőn */
	public abstract void interactedWith(Virologist v);
	/** Virológus befogadása, leszármazott definiálja a viselkedést */
	public abstract void acceptVirologist(Virologist v);
}
