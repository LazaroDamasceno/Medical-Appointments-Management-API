package com.api.v3.physician;

import com.api.v3.exceptions.PhysicianNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianService {

    private final PhysicianRepository repository;

    public Physician retrieve(String mln) {
        Optional<Physician> physician = repository.findByMln(mln);
        if (physician.isEmpty()) throw new PhysicianNotFoundException();
        return physician.get();
    }
}
