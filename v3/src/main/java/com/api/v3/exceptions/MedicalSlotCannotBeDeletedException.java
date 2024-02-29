package com.api.v3.exceptions;

public class MedicalSlotCannotBeDeletedException extends RuntimeException {

    public MedicalSlotCannotBeDeletedException() {
        super("Medical slot cannot be deleted.");
    }
    
}
