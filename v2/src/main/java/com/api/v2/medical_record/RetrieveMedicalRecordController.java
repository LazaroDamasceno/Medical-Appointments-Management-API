package com.api.v2.medical_record;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/medical-record")
@AllArgsConstructor
public class RetrieveMedicalRecordController {

    private final RetrieveMedicalRecordService service;

    @GetMapping("mln/{mln}/ssn/{ssn}")
    public final ResponseEntity<MedicalRecord> retrieve(@PathVariable String mln, @PathVariable String ssn) {
        return service.retrieve(mln, ssn);
    }
    
}
