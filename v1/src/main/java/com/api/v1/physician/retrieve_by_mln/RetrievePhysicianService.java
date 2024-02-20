package com.api.v1.physician.retrieve_by_mln;

import com.api.v1.facade.Facade;
import com.api.v1.generic_interfaces.retrieve.RetrieveWithOneParameter;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianService implements RetrieveWithOneParameter<ResponseEntity<Physician>, String> {

    private final PhysicianRepository repository;

    @Override
    public ResponseEntity<Physician> retrieve(String mln) {
        BigInteger bi_mln = Facade.turnToBigInteger(mln);
        Optional<Physician> optional = repository.findByMln(bi_mln);
        return optional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
