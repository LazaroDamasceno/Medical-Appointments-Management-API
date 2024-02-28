package com.api.v2.exceptions;

public class MedicalSlotNotFound extends RuntimeException {

    public MedicalSlotNotFound() {
        super("Medical slot does not exist.");
    }

}
