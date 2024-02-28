package com.api.v2.patient;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterPatientService {

    private final PatientRepository repository;

    public ResponseEntity<Void> register(RegisterPatientDTO dto) {
        Patient patient = new Patient(dto);
        repository.save(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
