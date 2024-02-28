package com.api.v2.exceptions;

public class MedicalRecordNotFound extends RuntimeException {

    public MedicalRecordNotFound() {
        super("Medical record does not exist.");
    }

}
