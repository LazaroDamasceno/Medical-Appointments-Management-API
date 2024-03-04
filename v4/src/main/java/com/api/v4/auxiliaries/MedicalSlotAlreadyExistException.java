package com.api.v4.auxiliaries;

public class MedicalSlotAlreadyExistException extends RuntimeException {

    public MedicalSlotAlreadyExistException() {
        super("Medical slot already exist.");
    }

}
