package inventory;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : inventory.InventorySorterVisitor.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import inventory.IInventoryVisitor;
import item.*;

import java.util.ArrayList;

/** Visitor, amely a kapott inventory szétválogatásáért,
 * illetve a kapott objektumokon végzett műveletekért felel */
public class InventorySorterVisitor implements IInventoryVisitor {
	/** Vitustáncot okozó ágensek */
	private ArrayList<Dancer> dancerItems;
	/** Vitustáncot okozó ágen receptek */
	private ArrayList<RDancer> rdancerItems;
	/** Felejtő ágensek */
	private ArrayList<Forgetter> forgetterItems;
	/** Felejtő ágens receptek */
	private ArrayList<RForgetter> rforgetterItems;
	/** Bénító ágensek */
	private ArrayList<Paralyzer> paralyzerItems;
	/** Bénító ágens receptek */
	private ArrayList<RParalyzer> rpalaryzerItems;
	/** Védő vakcinák */
	private ArrayList<Protector> protectorItems;
	/** Védő vakcina receptek */
	private ArrayList<RProtector> rprotectorItems;
	/** Zsákok */
	private ArrayList<Bag> bagItems;
	/** Kesztyűk */
	private ArrayList<Glove> gloveItems;
	/** Köpenyek */
	private ArrayList<Jacket> jacketItems;
	/** Aminosavak */
	private ArrayList<Aminoacid> aminoacidItems;
	/** Nukleoidok */
	private ArrayList<Nucleoid> nucleoidItems;

	/** Konstruktor, listák létrehozása */
	public InventorySorterVisitor() {
		dancerItems = new ArrayList<>();
		rdancerItems = new ArrayList<>();
		forgetterItems = new ArrayList<>();
		rforgetterItems = new ArrayList<>();
		paralyzerItems = new ArrayList<>();
		rpalaryzerItems = new ArrayList<>();
		protectorItems = new ArrayList<>();
		rprotectorItems = new ArrayList<>();
		bagItems = new ArrayList<>();
		gloveItems = new ArrayList<>();
		jacketItems = new ArrayList<>();
		aminoacidItems = new ArrayList<>();
		nucleoidItems = new ArrayList<>();
	}

	/** Getter - Dancerek */
	public ArrayList<Dancer> getDancerItems() {
		return dancerItems;
	}

	/** Getter - RDancerek */
	public ArrayList<RDancer> getRdancerItems() {
		return rdancerItems;
	}

	/** Getter - Forgetterek */
	public ArrayList<Forgetter> getForgetterItems() {
		return forgetterItems;
	}

	/** Getter - RForgetterek */
	public ArrayList<RForgetter> getRforgetterItems() {
		return rforgetterItems;
	}

	/** Getter - Paralyzerek */
	public ArrayList<Paralyzer> getParalyzerItems() {
		return paralyzerItems;
	}

	/** Getter - RParalyzerek */
	public ArrayList<RParalyzer> getRpalaryzerItems() {
		return rpalaryzerItems;
	}

	/** Getter - Protektorok */
	public ArrayList<Protector> getProtectorItems() {
		return protectorItems;
	}

	/** Getter - RProtektorok */
	public ArrayList<RProtector> getRprotectorItems() {
		return rprotectorItems;
	}

	/** Getter - Zsákok */
	public ArrayList<Bag> getBagItems() {
		return bagItems;
	}

	/** Getter - Kesztyűk */
	public ArrayList<Glove> getGloveItems() {
		return gloveItems;
	}

	/** Getter - Köpenyek */
	public ArrayList<Jacket> getJacketItems() {
		return jacketItems;
	}

	/** Getter - Aminosavak */
	public ArrayList<Aminoacid> getAminoacidItems() {
		return aminoacidItems;
	}

	/** Getter - Nukleoidok */
	public ArrayList<Nucleoid> getNucleoidItems() {
		return nucleoidItems;
	}

	/** A vitustáncot okozó ágens számlálója */
	public void visit(Dancer i) {
		dancerItems.add(i);
	}

	/** A vitustáncot okozó ágens receptjének számlálója */
	public void visit(RDancer i) {
		rdancerItems.add(i);
	}

	/** A felejtő ágens számlálója */
	public void visit(Forgetter i) {
		forgetterItems.add(i);
	}

	/** A felejtő ágens receptjének számlálója */
	public void visit(RForgetter i) {
		rforgetterItems.add(i);
	}

	/** A bénító ágens számlálója*/
	public void visit(Paralyzer i) {
		paralyzerItems.add(i);
	}

	/** A bénító ágens receptjének számlálója */
	public void visit(RParalyzer i) {
		rpalaryzerItems.add(i);
	}

	/** A védő vakcina számlálója */
	public void visit(Protector i) {
		protectorItems.add(i);
	}

	/** A védő vakcina receptjének számlálója */
	public void visit(RProtector i) {
		rprotectorItems.add(i);
	}

	/** A táska számlálója */
	public void visit(Bag i) {
		bagItems.add(i);
	}

	/** A kesztyű számlálója */
	public void visit(Glove i) {
		gloveItems.add(i);
	}

	/** A köpeny számlálója */
	public void visit(Jacket i) {
		jacketItems.add(i);
	}

	/** Az aminosav számlálója */
	public void visit(Aminoacid i) {
		aminoacidItems.add(i);
	}

	/** A nukleoid számlálója */
	public void visit(Nucleoid i) {
		nucleoidItems.add(i);
	}
}
