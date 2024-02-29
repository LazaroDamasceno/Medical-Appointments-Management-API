package com.api.v3.medical_record;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.api.v3.patient.Patient;


public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, UUID> {

    Optional<MedicalRecord> findByPatient(Patient patient);

}