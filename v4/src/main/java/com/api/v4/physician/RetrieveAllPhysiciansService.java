package com.api.v4.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RetrieveAllPhysiciansService {

    private final PhysicianRepository repository;

    public ResponseEntity<List<Physician>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
