package com.api.v3.auxiliaries;

public class MedicalNotesNotNullException extends RuntimeException {

    public MedicalNotesNotNullException() {
        super("Medical Notes are not null.");
    }

}
