package com.api.v2.physician;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {

    Optional<Physician> findByMln(String mln);

}
