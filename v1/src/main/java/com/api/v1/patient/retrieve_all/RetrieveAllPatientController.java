package com.api.v1.patient.retrieve_all;

import com.api.v1.generic_interfaces.retrieve_all.RetrieveAllWithoutParameters;
import com.api.v1.patient.Patient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
public class RetrieveAllPatientController implements RetrieveAllWithoutParameters<Patient> {

    private final RetrieveAllPatientsService service;

    @Override
    @GetMapping
    public ResponseEntity<List<Patient>> retriveAll() {
        return service.retriveAll();
    }

}
