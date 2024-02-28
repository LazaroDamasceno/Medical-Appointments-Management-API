package com.api.v2.exceptions;

public class PhysicianNotFoundException extends RuntimeException {

    public PhysicianNotFoundException() {
        super("The searched patient does not exist.");
    }

}
