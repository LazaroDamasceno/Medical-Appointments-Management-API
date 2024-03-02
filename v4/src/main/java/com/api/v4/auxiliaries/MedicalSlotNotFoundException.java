package com.api.v4.auxiliaries;

public class MedicalSlotNotFoundException extends RuntimeException {

    public MedicalSlotNotFoundException() {
        super("Medical slot does not exist.");
    }

}
