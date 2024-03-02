package com.api.v3.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query("""
        select p from Patient p
        where p.systemUser.ssn = :ssn
    """)
    Patient retrieve(@Param("ssn") @Pattern(regexp = "[//d]{9}") String ssn);

}
