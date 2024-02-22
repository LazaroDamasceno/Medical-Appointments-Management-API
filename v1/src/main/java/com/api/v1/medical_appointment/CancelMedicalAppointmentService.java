package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.MedicalSlotRepository;
import com.api.v1.medical_slot.RetrieveMedicalSlotByDateAndPhysicianService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class CancelMedicalAppointmentService {

    private final RetrieveMedicalAppointmentByPatientAndDateService service;
    private final MedicalAppointmentRepository repository;
    private final MedicalSlotRepository medicalSlotRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;

    public ResponseEntity<Void> cancel(String ssn, LocalDateTime dateTime) {
        Optional<MedicalAppointment> medicalAppointmentOptional = service.retrieve(ssn, dateTime);
        if (medicalAppointmentOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();
        medicalAppointment.setCancelationDateTime(LocalDateTime.now());
        repository.save(medicalAppointment);

        String mln = medicalAppointment.getPhysician().getMln();
        Optional<MedicalSlot> medicalSloOptional = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dateTime);
        if (medicalSloOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalSlot medicalSlot = medicalSloOptional.get();
        medicalSlot.setMedicalAppointment(null);
        medicalSlotRepository.save(medicalSlot);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
