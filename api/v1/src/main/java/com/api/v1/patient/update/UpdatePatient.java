package com.api.v1.patient.update;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface UpdatePatient {
    
    ResponseEntity<Void> update(@NotNull UpdatePatientDTO dto);

}
