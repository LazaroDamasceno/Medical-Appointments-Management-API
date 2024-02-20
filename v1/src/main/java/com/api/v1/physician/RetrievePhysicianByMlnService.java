package com.api.v1.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianByMlnService {

    private final PhysicianRepository repository;

    public ResponseEntity<Physician> retrieve(String mln) {
        Optional<Physician> optional = repository.findByMln(new BigInteger(mln));
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.badRequest().build();
    }
}
