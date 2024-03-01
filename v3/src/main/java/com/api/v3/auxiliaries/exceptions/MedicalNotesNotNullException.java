package com.api.v3.auxiliaries.exceptions;

public class MedicalNotesNotNullException extends RuntimeException {

    public MedicalNotesNotNullException() {
        super("Medical Notes are not null.");
    }

}
