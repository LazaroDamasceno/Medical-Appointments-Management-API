package com.api.v3.auxiliaries.exceptions;

public class MedicalAppointmentAlreadyExistException extends RuntimeException {

    public MedicalAppointmentAlreadyExistException() {
        super("Medical appointment already exist.");
    }
    
}
