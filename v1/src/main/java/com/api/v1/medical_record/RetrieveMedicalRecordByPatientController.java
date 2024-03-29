package com.api.v1.medical_record;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-record")
@AllArgsConstructor
public class RetrieveMedicalRecordByPatientController {

    private final RetrieveMedicalRecordByPatientService service;

    @GetMapping("mln/{mln}/ssn/{ssn}")
    public final ResponseEntity<MedicalRecord> retrieve(@PathVariable String mln, @PathVariable String ssn) {
        return service.retrieve(mln, ssn);
    }
    
}
