package com.api.v1.patient;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
public class RetrieveAllPatientController {

    private final RetrieveAllPatientsService service;

    @GetMapping
    public ResponseEntity<List<Patient>> retriveAll() {
        return service.retriveAll();
    }

}
