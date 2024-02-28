package com.api.v2.exceptions;

public class MedicalAppointmentAlreadyExist extends RuntimeException {

    public MedicalAppointmentAlreadyExist() {
        super("The medical appointment already exist.");
    }

}
