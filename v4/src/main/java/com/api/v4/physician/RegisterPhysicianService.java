package com.api.v4.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.auxiliaries.EntityCannotBePersistedException;

@Service
@AllArgsConstructor
public class RegisterPhysicianService {

    private final PhysicianRepository repository;
    private final RetrievePhysicianService service;

    public ResponseEntity<Void> register(RegisterPhysicianDTO dto) {
        if (service.retrieve(dto.mln()) != null) throw new EntityCannotBePersistedException();
        Physician physician = new Physician(dto);
        repository.save(physician);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
