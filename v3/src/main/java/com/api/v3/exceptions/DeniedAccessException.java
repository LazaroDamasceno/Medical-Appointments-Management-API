package com.api.v3.exceptions;

public class DeniedAccessException extends RuntimeException {

    public DeniedAccessException() {
        super("Access denied.");
    }
    
}
