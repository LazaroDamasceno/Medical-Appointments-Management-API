package com.api.v4.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterPhysicianService {

    final PhysicianRepository repository;

    public ResponseEntity<Void> register(RegisterPhysicianDTO dto) {
        Physician physician = new Physician(dto);
        repository.save(physician);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
