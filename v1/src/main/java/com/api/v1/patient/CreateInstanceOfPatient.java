package com.api.v1.patient;

import com.api.v1.patient.register.RegisterPatientDTO;

public interface CreateInstanceOfPatient {

    static Patient create(RegisterPatientDTO dto) {
        return new Patient(dto);
    }

}
