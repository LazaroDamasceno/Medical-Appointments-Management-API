package com.api.v2.medical_record;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/medical-records")
@AllArgsConstructor
public class RetrieveAllMedicalRecordsByPhysicianController {

    private final RetrieveAllMedicalRecordsByPhysicianService service;

    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalRecord>> retrieve(@PathVariable String mln) {
        return service.retrieve(mln);
    }
    
}
