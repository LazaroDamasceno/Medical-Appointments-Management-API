package com.api.v1.physician;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {

    Optional<Physician> findByMln(BigInteger mln);

}
