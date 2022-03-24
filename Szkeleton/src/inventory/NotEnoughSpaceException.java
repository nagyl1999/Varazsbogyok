package inventory;

/**
 * Inventory hely hiányában dobandó kivétel
 */
public class NotEnoughSpaceException extends Exception {

    /**
     * Konstruktor, üzenet átadása
     */
    public NotEnoughSpaceException(String message) {
        super(message);
    }
}
