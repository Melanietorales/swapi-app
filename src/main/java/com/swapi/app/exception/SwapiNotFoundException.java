package com.swapi.app.exception;

public class SwapiNotFoundException extends RuntimeException {
    public SwapiNotFoundException(String message) {
        super(message);
    }
}
