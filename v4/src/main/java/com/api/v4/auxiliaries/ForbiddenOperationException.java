package com.api.v4.auxiliaries;

public class ForbiddenOperationException extends RuntimeException {

    public ForbiddenOperationException() {
        super("Forbidden operation.");
    }
    
}
