package com.api.v1.medical_prescription;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface MedicalPrescriptionRepository extends JpaRepository<MedicalPrescription, UUID> {

    Optional<MedicalPrescription> findByMedicalAppointment(MedicalAppointment medicalAppointmen);
    
}
