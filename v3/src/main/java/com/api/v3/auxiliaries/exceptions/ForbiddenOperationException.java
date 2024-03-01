package com.api.v3.auxiliaries.exceptions;

public class ForbiddenOperationException extends RuntimeException {

    public ForbiddenOperationException() {
        super("Forbidden operation.");
    }
    
}
