package com.api.v4.medical_record;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.physician.Physician;
import com.api.v4.physician.RetrievePhysicianService;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class RetrieveAllMedicalRecordsService {    

    private final RetrievePhysicianService retrievePhysician;
    private final MedicalRecordRepository repository;
    
    public ResponseEntity<List<MedicalRecord>> retrieve(@Pattern(regexp = "[0-9]{7}") String mln) {
        Physician physician = retrievePhysician.retrieve(mln);

        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician))
                        .toList()
        );
    }

}
