package com.api.v2.exceptions;

public class MedicalAppointmentNotFound extends RuntimeException {

    public MedicalAppointmentNotFound(String message) {
        super(message);
    }

}
