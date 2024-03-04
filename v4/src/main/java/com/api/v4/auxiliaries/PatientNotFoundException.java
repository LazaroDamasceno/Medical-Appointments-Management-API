package com.api.v4.auxiliaries;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        super("Patient does not exist.");
    }

}