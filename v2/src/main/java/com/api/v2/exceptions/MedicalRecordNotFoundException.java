package com.api.v2.exceptions;

public class MedicalRecordNotFoundException extends RuntimeException {

    public MedicalRecordNotFoundException() {
        super("Medical record does not exist.");
    }

}
