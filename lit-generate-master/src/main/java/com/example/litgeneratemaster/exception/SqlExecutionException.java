package com.example.litgeneratemaster.exception;

public class SqlExecutionException extends Exception {
    public SqlExecutionException(String message) {
        super(message);
    }

    public SqlExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
