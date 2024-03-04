package com.api.v4.patient;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.auxiliaries.EntityCannotBePersistedException;

@Service
@AllArgsConstructor
public class RegisterPatientService {

    private final PatientRepository repository;
    private final RetrievePatientService service;

    public ResponseEntity<Void> register(RegisterPatientDTO dto) {
        if (service.retrieve(dto.systemUserDTO().ssn()) != null) throw new EntityCannotBePersistedException();
        Patient patient = new Patient(dto);
        repository.save(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
