package com.api.v3.auxiliaries.exceptions;

public class MedicalSlotNotFoundException extends RuntimeException {

    public MedicalSlotNotFoundException() {
        super("Medical slot does not exist.");
    }

}
