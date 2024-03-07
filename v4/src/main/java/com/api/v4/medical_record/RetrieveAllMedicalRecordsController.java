package com.api.v4.medical_record;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-records")
@AllArgsConstructor
class RetrieveAllMedicalRecordsController {

    private final RetrieveAllMedicalRecordsService service;

    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalRecord>> retrieve(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln) {
        return service.retrieve(mln);
    }
    
}
