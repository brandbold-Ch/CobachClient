package org.core.adapters.exceptions;

public class NotFound extends Exception {

    public NotFound() {super();}

    public NotFound(String message) {
        super(message);
    }

    public NotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
