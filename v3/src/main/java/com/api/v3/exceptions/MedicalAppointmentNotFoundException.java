package com.api.v3.exceptions;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException() {
        super("Medical appointment does not exist.");
    }

}
