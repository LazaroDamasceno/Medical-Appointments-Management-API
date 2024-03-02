package com.api.v4.auxiliaries;

public class MedicalSlotCannotBeDeletedException extends RuntimeException {

    public MedicalSlotCannotBeDeletedException() {
        super("Medical slot cannot be deleted.");
    }
    
}
