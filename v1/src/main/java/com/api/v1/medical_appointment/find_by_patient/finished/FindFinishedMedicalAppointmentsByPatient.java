package com.api.v1.medical_appointment.find_by_patient.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputDTO;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithPhysicianDTO;

import jakarta.validation.constraints.NotNull;

public interface FindFinishedMedicalAppointmentsByPatient {
    
    ResponseEntity<List<MedicalAppointment>> find(@NotNull MedicalAppointmentInputDTO dto);

    ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull MedicalAppointmentInputWithPhysicianDTO dto);

}
