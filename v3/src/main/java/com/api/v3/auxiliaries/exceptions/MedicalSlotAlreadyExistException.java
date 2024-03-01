package com.api.v3.auxiliaries.exceptions;

public class MedicalSlotAlreadyExistException extends RuntimeException {

    public MedicalSlotAlreadyExistException() {
        super("Medical slot already exist.");
    }

}
