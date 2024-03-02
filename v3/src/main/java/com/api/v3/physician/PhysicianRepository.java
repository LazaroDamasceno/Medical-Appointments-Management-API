package com.api.v3.physician;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

import jakarta.validation.constraints.Pattern;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {

    Optional<Physician> findByMln(@Pattern(regexp = "[0-9]{7}") String mln);

}
