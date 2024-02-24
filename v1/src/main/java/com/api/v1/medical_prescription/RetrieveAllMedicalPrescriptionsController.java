package com.api.v1.medical_prescription;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-prescriptions")
@AllArgsConstructor
public class RetrieveAllMedicalPrescriptionsController {

    private final RetrieveAllMedicalPrescriptionsService service;

    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalPrescription>> retrieve(@PathVariable String mln) {
        return service.retrieve(mln);
    }
    
}
