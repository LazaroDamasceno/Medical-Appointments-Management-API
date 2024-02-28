package com.api.v2.exceptions;

public class PhysicianNotFoundException extends RuntimeException {

    public PhysicianNotFoundException(String message) {
        super(message);
    }

}
