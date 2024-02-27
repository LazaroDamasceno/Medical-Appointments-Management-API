package com.api.v1.medical_prescription;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalPrescriptionsService {

    private final MedicalPrescriptionRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;

    public ResponseEntity<List<MedicalPrescription>> retrieve(String mln) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        return physician.map(value -> ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(value))
                        .toList()
        )).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
}
