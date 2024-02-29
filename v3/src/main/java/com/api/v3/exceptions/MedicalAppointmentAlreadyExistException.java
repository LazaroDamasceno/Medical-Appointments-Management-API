package com.api.v3.exceptions;

public class MedicalAppointmentAlreadyExistException extends RuntimeException {

    public MedicalAppointmentAlreadyExistException() {
        super("Medical appointment already exist.");
    }
    
}
