package item;

/*

  Generated by StarUML(tm) Java Add-In

  @ Project : Varazsbogyok
  @ File Name : item.Nucleoid.java
  @ Date : 2022. 03. 23.
  @ Author : varazsbogyok

*/

import inventory.IInventoryVisitor;

/**
 * A material leszármazottja, egy gyűjthető anyag.
 */
public class Nucleoid extends Material {
    /**
     * Ikon elérési út
     */
    protected String iconPath = "resources\\nucleotid.jpg";
    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a nukleotid típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }
    /**
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
    }
}
