package com.api.v4.physician;

import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v4.auxiliaries.ForbiddenOperationException;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
public class RetrievePhysicianService {

    private final PhysicianRepository repository;

    public Physician retrieve(@Pattern(regexp = "[0-9]{7}") String mln) {
        Optional<Physician> physician = repository
            .findAll()
            .stream()
            .filter(e -> e.getMln().equals(mln) && e.getTerminationDate() == null)
            .findFirst();
        if (physician.isEmpty()) throw new ForbiddenOperationException();
        return physician.get();
    }

}
