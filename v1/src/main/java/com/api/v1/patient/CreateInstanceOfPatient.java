package com.api.v1.patient;

public interface CreateInstanceOfPatient {

    static Patient create(RegisterPatientDTO dto) {
        return new Patient(dto);
    }

}
