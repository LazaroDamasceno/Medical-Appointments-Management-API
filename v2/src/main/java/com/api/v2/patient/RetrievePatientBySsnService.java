package com.api.v2.patient;

import com.api.v2.exceptions.PatientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientBySsnService {

    private final PatientRepository repository;

    public Patient retrieve(String ssn) {
        Optional<Patient> patient = Optional.ofNullable(repository.retrieve(ssn));
        String message = String.format("The patient whose ssb is %s does not exist.", ssn);
        if (patient.isEmpty()) throw new PatientNotFoundException(message);
        return patient.get();
    }

}
