package com.api.v2.medical_appointment.cancel;

import java.time.LocalDate;

import com.api.v2.exceptions.MedicalNotesNotNull;
import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import com.api.v2.medical_appointment.RetrieveMedicalAppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.auxiliary.DateTimeDTO;
import com.api.v2.medical_slot.MedicalSlot;
import com.api.v2.medical_slot.MedicalSlotRepository;
import com.api.v2.medical_slot.RetrieveMedicalSlotService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class CancelMedicalAppointmentService {

    private final RetrieveMedicalAppointmentService retrieveMedicalAppointment;
    private final MedicalAppointmentRepository repository;
    private final RetrieveMedicalSlotService retrieveMedicalSlot;
    private final MedicalSlotRepository medicalSlotRepository;

    public ResponseEntity<Void> cancel(String ssn, DateTimeDTO dto) {
        MedicalAppointment medicalAppointment = retrieveMedicalAppointment.retrieveByPatient(ssn, dto);
        if (medicalAppointment.getMedicalNotes() != null) throw new MedicalNotesNotNull();
        medicalAppointment.setCancellationDate(LocalDate.now());
        repository.save(medicalAppointment);

        String mln = medicalAppointment.getPhysician().getMln();
        MedicalSlot medicalSlot = retrieveMedicalSlot.retrieve(mln, dto);
        medicalSlot.setMedicalAppointment(null);
        medicalSlotRepository.save(medicalSlot);
        
        return ResponseEntity.noContent().build();
    }
    
}
