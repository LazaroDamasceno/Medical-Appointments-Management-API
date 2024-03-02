package com.api.v3.patient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.api.v3.auxiliaries.PatientNotFoundException;

import jakarta.validation.constraints.Pattern;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientService {

    private final PatientRepository repository;

    public Patient retrieve(@Pattern(regexp = "[//d]{9}") String ssn) {
        Optional<Patient> patient = Optional.ofNullable(repository.retrieve(ssn));
        if (patient.isEmpty()) throw new PatientNotFoundException();
        return patient.get();
    }

}
