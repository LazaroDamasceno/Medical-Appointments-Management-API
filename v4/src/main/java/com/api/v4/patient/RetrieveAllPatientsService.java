package com.api.v4.patient;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RetrieveAllPatientsService {

    private final PatientRepository repository;

    public ResponseEntity<List<Patient>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
