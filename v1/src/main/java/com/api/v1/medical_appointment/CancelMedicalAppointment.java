package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class CancelMedicalAppointmentService {

    private final RetrieveMedicalAppointmentByPatientAndDateService service;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<Void> cancel(String ssn, DateTimeDTO dto) {
        Optional<MedicalAppointment> medicalAppointmentOptional = service.retrieve(ssn, dto);
        if (medicalAppointmentOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();
        medicalAppointment.setCancelationDateTime(LocalDateTime.now());
        repository.save(medicalAppointment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
