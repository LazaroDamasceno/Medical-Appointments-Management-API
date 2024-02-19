package com.api.v1.patient.retrieve_by_ssn;

import com.api.v1.generics.Retrieve;
import com.api.v1.patient.Patient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/patient")
public class RetrievePatientController implements Retrieve<ResponseEntity<Patient>, Long> {

    private final RetrievePatientService service;

    @Override
    @GetMapping("{ssn}")
    public ResponseEntity<Patient> retrieve(@PathVariable Long ssn) {
        return service.retrieve(ssn);
    }

}
