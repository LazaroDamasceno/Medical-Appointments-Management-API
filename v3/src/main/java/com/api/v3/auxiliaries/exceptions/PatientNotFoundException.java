package com.api.v3.auxiliaries.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super("Patient does not exist.");
    }

}