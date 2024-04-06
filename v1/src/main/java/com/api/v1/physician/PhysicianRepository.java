package com.api.v1.physician;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {
	
	Optional<Physician> findByMln(@NotBlank @Size(min=9, max=9) String mln);

}