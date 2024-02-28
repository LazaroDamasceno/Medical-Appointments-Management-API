package com.api.v2.exceptions;

public class MedicalSlotAlreadyExist extends RuntimeException {

    public MedicalSlotAlreadyExist() {
        super("Medical slot already exist.");
    }

}
