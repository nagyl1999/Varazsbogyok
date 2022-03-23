package item;/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Agent.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import inventory.IStorable;

/** */
public abstract class Agent implements IStorable, Steppable {
	/** */
	protected int expire;
	
	/** */
	private Virologist virologist;
	
	/** */
	public abstract void effect(Virologist v);
	
	/** */
	public abstract void decompose(Virologist v);
	
	/** */
	public abstract void protect(Virologist v, Agent a);
	
	/** */
	public abstract void use(Virologist v1, Virologist v2);
}
