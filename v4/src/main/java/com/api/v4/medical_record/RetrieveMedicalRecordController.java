package com.api.v4.medical_record;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-record")
@AllArgsConstructor
public class RetrieveMedicalRecordController {

    private final RetrieveMedicalRecordService service;

    @GetMapping("mln/{mln}/ssn/{ssn}")
    public final ResponseEntity<MedicalRecord> retrieve(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, @PathVariable @Pattern(regexp = "[0-9]{9}") String ssn) {
        return service.retrieve(mln, ssn);
    }
    
}
