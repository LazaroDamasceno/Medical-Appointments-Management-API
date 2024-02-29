package com.api.v2.exceptions;

public class MedicalSlotAlreadyExistException extends RuntimeException {

    public MedicalSlotAlreadyExistException() {
        super("Medical slot already exist.");
    }

}
