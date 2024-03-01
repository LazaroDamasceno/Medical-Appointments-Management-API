package com.api.v3.patient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.api.v3.auxiliaries.exceptions.PatientNotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientService {

    private final PatientRepository repository;

    public Patient retrieve(String ssn) {
        Optional<Patient> patient = Optional.ofNullable(repository.retrieve(ssn));
        if (patient.isEmpty()) throw new PatientNotFoundException();
        return patient.get();
    }

}
