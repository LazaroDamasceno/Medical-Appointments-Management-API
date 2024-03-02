package com.api.v3.auxiliaries;

public class MedicalSlotAlreadyExistException extends RuntimeException {

    public MedicalSlotAlreadyExistException() {
        super("Medical slot already exist.");
    }

}
