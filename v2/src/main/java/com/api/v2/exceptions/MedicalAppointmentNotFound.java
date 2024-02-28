package com.api.v2.exceptions;

public class MedicalAppointmentNotFound extends RuntimeException {

    public MedicalAppointmentNotFound() {
        super("Medical appointment does not exist.");
    }

}
