package com.api.v2.medical_record;

import java.util.Optional;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalRecordsByPhysicianService {    

    private final MedicalRecordRepository repository;
    private final RetrievePhysicianService retrievePhysician
;
    
    public ResponseEntity<List<MedicalRecord>> retrieve(String mln) {
        Physician physician = retrievePhysician.retrieve(mln);

        return physician.map(value -> ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(value))
                        .toList()
        )).orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
