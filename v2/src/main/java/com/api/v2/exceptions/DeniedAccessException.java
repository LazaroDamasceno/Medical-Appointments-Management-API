package com.api.v2.exceptions;

public class DeniedAccessException extends RuntimeException {

    public DeniedAccessException() {
        super("Access denied.");
    }
    
}
