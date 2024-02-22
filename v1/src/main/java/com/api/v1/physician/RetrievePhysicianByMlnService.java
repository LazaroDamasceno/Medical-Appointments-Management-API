package com.api.v1.physician;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianByMlnService {

    private final PhysicianRepository repository;

    public Optional<Physician> retrieve(String mln) {
        return repository.findByMln(mln);
    }
}
