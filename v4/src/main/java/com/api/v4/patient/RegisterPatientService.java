package com.api.v4.patient;

import com.api.v4.auxiliaries.ForbiddenOperationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterPatientService {

    private final PatientRepository repository;

    public ResponseEntity<Void> register(RegisterPatientDTO dto) {
        Optional<Patient> patientOptional = Optional.ofNullable(repository.retrieve(dto.systemUserDTO().ssn()));
        if (patientOptional.isPresent()) throw new ForbiddenOperationException();
        Patient patient = new Patient(dto);
        repository.save(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
