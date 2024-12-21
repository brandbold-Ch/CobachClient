package org.core.adapters.exceptions;

public class IncorrectPassword  extends Exception{

    public IncorrectPassword() {super();}

    public IncorrectPassword(String message) {
        super(message);
    }

    public IncorrectPassword(String message, Throwable cause) {
        super(message, cause);
    }
}
