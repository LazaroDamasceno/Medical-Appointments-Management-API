package com.api.v1.patient.retrieve_all;

import com.api.v1.generic_interfaces.retrieve_all.RetrieveAllWithoutParameters;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllPatientsService implements RetrieveAllWithoutParameters<Patient> {

    private final PatientRepository repository;

    @Override
    public ResponseEntity<List<Patient>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
