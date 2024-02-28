package com.api.v2.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super("Patient does not exist.");
    }

}