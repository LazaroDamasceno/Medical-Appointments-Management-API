package com.api.v1.patient;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/patient")
public class RetrievePatientBySsnController {

    private final RetrievePatientBySsnService service;

    @GetMapping("{ssn}")
    public ResponseEntity<Patient> retrieve(@PathVariable String ssn) {
        return service.retrieve(ssn);
    }

}
