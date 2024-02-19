package com.api.v1.physician.retrieve_mln;

import com.api.v1.generics.Retrieve;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianService implements Retrieve<ResponseEntity<Physician>, Long> {

    private final PhysicianRepository repository;

    @Override
    public ResponseEntity<Physician> retrieve(Long mln) {
        BigInteger bi_mln = BigInteger.valueOf(mln);
        Optional<Physician> optional = repository.findByMln(bi_mln);
        return optional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
