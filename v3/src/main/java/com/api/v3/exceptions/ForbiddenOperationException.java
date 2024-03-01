package com.api.v3.exceptions;

public class ForbiddenOperationException extends RuntimeException {

    public ForbiddenOperationException() {
        super("Forbidden operation.");
    }
    
}
