package com.api.v1.physician.retrieve_by_mln;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianService {

    private final PhysicianRepository repository;

    public ResponseEntity<Physician> retrieve(String mln) {
        Optional<Physician> optional = repository.findByMln(new BigInteger(mln));
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.badRequest().build();
    }
}
