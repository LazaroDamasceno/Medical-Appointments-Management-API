package com.api.v4.medical_appointment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, UUID> {
    
}
