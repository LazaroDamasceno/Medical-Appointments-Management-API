package com.api.v4.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
class TerminatePhysicianService {

    private final PhysicianRepository repository;
    private final RetrievePhysicianService service;

    public ResponseEntity<Void> terminate(@Pattern(regexp = "[0-9]{7}") String mln) {
        Physician physician = service.retrieve(mln);
        physician.setTerminationDate(LocalDate.now());
        repository.save(physician);
        return ResponseEntity.noContent().build();
    }
}
