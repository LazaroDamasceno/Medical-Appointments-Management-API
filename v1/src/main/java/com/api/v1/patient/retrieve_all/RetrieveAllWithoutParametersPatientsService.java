package com.api.v1.patient.retrieve_all;

import com.api.v1.generics.RetrieveAllWithoutParameters;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllWithoutParametersPatientsService implements RetrieveAllWithoutParameters<Patient> {

    private final PatientRepository repository;

    @Override
    public ResponseEntity<List<Patient>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
