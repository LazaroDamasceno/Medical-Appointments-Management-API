package com.api.v4.auxiliaries;

public class PhysicianNotFoundException extends RuntimeException {

    public PhysicianNotFoundException() {
        super("The searched patient does not exist.");
    }

}
