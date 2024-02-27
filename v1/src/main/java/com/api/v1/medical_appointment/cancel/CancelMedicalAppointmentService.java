package com.api.v1.medical_appointment.cancel;

import java.time.LocalDateTime;
import java.util.Optional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.RetrieveMedicalAppointmentByPatientAndDateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
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

    public ResponseEntity<Void> cancel(String ssn, DateTimeDTO dto) {
        Optional<MedicalAppointment> medicalAppointmentOptional = service.retrieve(ssn, dto);

        if (medicalAppointmentOptional.isPresent() 
            && medicalAppointmentOptional.get().getMedicalNotes() != null) return ResponseEntity.badRequest().build();

        if (medicalAppointmentOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();
        medicalAppointment.setCancellationDateTime(LocalDateTime.now());
        repository.save(medicalAppointment);

        String mln = medicalAppointment.getPhysician().getMln();
        Optional<MedicalSlot> medicalSloOptional = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dto);
        if (medicalSloOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalSlot medicalSlot = medicalSloOptional.get();
        medicalSlot.setMedicalAppointment(null);
        medicalSlotRepository.save(medicalSlot);
        
        return ResponseEntity.noContent().build();
    }
    
}
