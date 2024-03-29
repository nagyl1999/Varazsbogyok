package inventory;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : inventory.IStorable.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/


import graphics.IIcon;

/**
 * Minden tárolható objektum összefoglaló interfésze
 */
public interface IStorable extends IIcon {
    /**
     * Kötelezően fogadandó visitor, az implementáló
     * objektumok saját magukkal hívják a visitor
     * visit függvényét
     */
    public void accept(IInventoryVisitor i);

    /**
     * Ikon elérési út, minden tárolható dolognak ikonnal
     * is kell rendelkeznie a megjelenítés érdekében
     */
    public String getIconPath();
}
