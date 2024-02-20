package com.api.v1.physician.retrieve_all;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrievePhysiciansService {

    private final PhysicianRepository repository;

    public ResponseEntity<List<Physician>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
