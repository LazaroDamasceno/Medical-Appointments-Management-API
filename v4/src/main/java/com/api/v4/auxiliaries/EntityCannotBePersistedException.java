package com.api.v4.auxiliaries;

public class EntityCannotBePersistedException extends RuntimeException {

    public EntityCannotBePersistedException() {
        super("Entity cannot be persisted.");
    }
    
}
