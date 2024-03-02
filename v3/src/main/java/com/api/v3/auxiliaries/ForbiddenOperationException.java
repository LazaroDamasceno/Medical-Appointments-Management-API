package com.api.v3.auxiliaries;

public class ForbiddenOperationException extends RuntimeException {

    public ForbiddenOperationException() {
        super("Forbidden operation.");
    }
    
}
