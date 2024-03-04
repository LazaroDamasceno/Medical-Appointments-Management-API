package com.api.v4.auxiliaries;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException() {
        super("Medical appointment does not exist.");
    }

}
