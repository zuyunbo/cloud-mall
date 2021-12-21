package com.parserc.exception;

public class MatchException extends Exception {
    public MatchException(String message) {
        super(message);
    }

    public MatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
