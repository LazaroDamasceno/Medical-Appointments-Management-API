package com.api.v2.exceptions;

public class MedicalNotesNotNull extends RuntimeException {

    public MedicalNotesNotNull() {
        super("Medical Notes are not null.");
    }

}
