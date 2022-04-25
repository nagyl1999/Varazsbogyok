package entity;

public class StateDoesNotAllowActionException extends Exception {
    /**
     * Konstruktor, üzenet átadása
     */
    public StateDoesNotAllowActionException(String message) {
        super(message);
    }
}
