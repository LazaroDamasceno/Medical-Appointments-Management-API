package com.api.v2.exceptions;

public class MedicalSlotNotFoundException extends RuntimeException {

    public MedicalSlotNotFoundException() {
        super("Medical slot does not exist.");
    }

}
