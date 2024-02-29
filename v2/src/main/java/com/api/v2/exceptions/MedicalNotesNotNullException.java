package com.api.v2.exceptions;

public class MedicalNotesNotNullException extends RuntimeException {

    public MedicalNotesNotNullException() {
        super("Medical Notes are not null.");
    }

}
