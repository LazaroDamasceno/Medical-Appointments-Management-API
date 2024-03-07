package com.api.v4.patient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.api.v4.auxiliaries.PatientNotFoundException;

import java.util.Optional;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
class RetrievePatientService {

    private final PatientRepository repository;

    public Patient retrieve(@Pattern(regexp = "[0-9]{9}") String ssn) {
        Optional<Patient> patient = Optional.ofNullable(repository.retrieve(ssn));
        if (patient.isEmpty()) throw new PatientNotFoundException();
        return patient.get();
    }

}
