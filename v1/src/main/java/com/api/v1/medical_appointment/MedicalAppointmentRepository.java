package com.api.v1.medical_appointment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, UUID> {
    
}
