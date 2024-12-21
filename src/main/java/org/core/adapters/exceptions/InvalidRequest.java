package org.core.adapters.exceptions;

public class InvalidRequest extends Exception {

    public InvalidRequest() {super();}

    public InvalidRequest(String message) {
        super(message);
    }

    public InvalidRequest(String message, Throwable cause) {
        super(message, cause);
    }
}
