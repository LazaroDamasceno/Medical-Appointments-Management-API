package com.api.v3.physician;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.Pattern;

import java.util.Optional;
import java.util.UUID;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {

    Optional<Physician> findByMln(@Pattern(regexp = "[//d]{7}") String mln);

}
