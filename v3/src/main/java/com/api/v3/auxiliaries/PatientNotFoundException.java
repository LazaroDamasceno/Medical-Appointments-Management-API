package com.api.v3.auxiliaries;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super("Patient does not exist.");
    }

}