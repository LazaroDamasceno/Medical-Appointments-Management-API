package com.api.v4.auxiliaries;

public class MedicalAppointmentAlreadyExistException extends RuntimeException {

    public MedicalAppointmentAlreadyExistException() {
        super("Medical appointment already exist.");
    }
    
}
