package com.api.v2.patient;

import com.api.v2.exceptions.PatientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
