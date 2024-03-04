package com.api.v4.auxiliaries;

public class MedicalNotesNotNullException extends RuntimeException {

    public MedicalNotesNotNullException() {
        super("Medical Notes are not null.");
    }

}
