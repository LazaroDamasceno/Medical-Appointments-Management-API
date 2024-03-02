package com.api.v3.medical_record;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v3/medical-records")
@AllArgsConstructor
public class RetrieveAllMedicalRecordsController {

    private final RetrieveAllMedicalRecordsService service;

    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalRecord>> retrieve(@PathVariable @Pattern(regexp = "[//d]{7}") String mln) {
        return service.retrieve(mln);
    }
    
}
