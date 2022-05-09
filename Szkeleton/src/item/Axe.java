package item;

import entity.Virologist;
import inventory.IInventoryVisitor;
import inventory.IStorable;
import inventory.VisitorManager;

public class Axe extends Gear {
    /**
     * Ikon elérési út
     */
    protected String iconPath = "";
    /**
     * Hátralévő használatok száma
     */
    public static int DURABILITY = -1;

    /**
     * Konstruktor
     */
    public Axe() {
        super(Axe.DURABILITY);
    }

    /**
     * Getter - Ikon elérési út
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * A balta nem véd
     */
    public void protect(Virologist v1, Virologist v2, Agent a) {
    }

    /**
     * A paraméterben kapott virológus a védőfelszerelésre vált.
     */
    public void equip(Virologist v) {
        equipped = true;
    }

    /**
     * A paraméterben kapott virológus másik védőfelszerelésre vált.
     */
    public void unequip(Virologist v) {
        equipped = false;
    }

    /**
     * A visitor tervezési mintát ez a függvény valósítja meg, ez fogja fogadni a zsák típust.
     */
    public void accept(IInventoryVisitor i) {
        i.visit(this);
    }

    /**
     * Amennyiben a virológus medvevírussal fertőzött
     * a kapott játékost a baltával megölhetjük
     *
     * @param v A fertőzöttnek gondolt játékos
     */
    public void use(Virologist v) {
        if (durability == 0 || !VisitorManager.hasBear(v))
            return;
        v.die();
        durability--;
    }
}
