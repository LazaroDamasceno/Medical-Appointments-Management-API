package com.api.v3.medical_record;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalRecordsService {    

    private final RetrievePhysicianService retrievePhysician;
    private final MedicalRecordRepository repository;
    
    public ResponseEntity<List<MedicalRecord>> retrieve(String mln) {
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
