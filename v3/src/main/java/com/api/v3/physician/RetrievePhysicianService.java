package com.api.v3.physician;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.api.v3.auxiliaries.PhysicianNotFoundException;

import jakarta.validation.constraints.Pattern;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePhysicianService {

    private final PhysicianRepository repository;

    public Physician retrieve(@Pattern(regexp = "[//d]{7}") String mln) {
        Optional<Physician> physician = repository.findByMln(mln);
        if (physician.isEmpty()) throw new PhysicianNotFoundException();
        return physician.get();
    }
}
