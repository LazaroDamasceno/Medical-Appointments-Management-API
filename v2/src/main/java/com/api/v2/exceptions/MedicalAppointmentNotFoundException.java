package com.api.v2.exceptions;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException() {
        super("Medical appointment does not exist.");
    }

}
