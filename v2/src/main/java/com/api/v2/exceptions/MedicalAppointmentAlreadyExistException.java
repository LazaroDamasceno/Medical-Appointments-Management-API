package com.api.v2.exceptions;

public class MedicalAppointmentAlreadyExistException extends RuntimeException {

    public MedicalAppointmentAlreadyExistException() {
        super("Medical appointment already exist.");
    }
    
}
