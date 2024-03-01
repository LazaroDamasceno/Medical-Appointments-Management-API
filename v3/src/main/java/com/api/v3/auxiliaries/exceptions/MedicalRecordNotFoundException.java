package com.api.v3.auxiliaries.exceptions;

public class MedicalRecordNotFoundException extends RuntimeException {

    public MedicalRecordNotFoundException() {
        super("Medical record does not exist.");
    }

}
