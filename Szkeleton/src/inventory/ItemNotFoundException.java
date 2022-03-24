package inventory;

/**
 * Kivétel, amennyiben egy keresett dolog nem található meg az inventory-ban
 */
public class ItemNotFoundException extends Exception {

    /**
     * Konstruktor, üzenet átadása
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
