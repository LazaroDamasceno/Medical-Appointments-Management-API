package com.api.v2.medical_appointment.register;

import java.util.Optional;

import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import com.api.v2.medical_appointment.RetrieveMedicalAppointmentByPatientAndDateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.auxiliary.DateTimeDTO;
import com.api.v2.medical_slot.MedicalSlot;
import com.api.v2.medical_slot.MedicalSlotRepository;
import com.api.v2.medical_slot.RetrieveMedicalSlotByDateAndPhysicianService;
import com.api.v2.patient.Patient;
import com.api.v2.patient.RetrievePatientBySsnService;
import com.api.v2.physician.Physician;
import com.api.v2.physician.PhysicianRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalAppointmentService {

    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final RetrievePatientBySsnService retrievePatientBySsn;
    private final PhysicianRepository physicianRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;
    private final MedicalSlotRepository medicalSlotRepository;
    private final RetrieveMedicalAppointmentByPatientAndDateService retrieveMedicalAppointmentByPatientAndDate;

    public ResponseEntity<Void> register(String mln, String ssn, DateTimeDTO dto) {
        Optional<MedicalAppointment> medicalAppointmentOptional = retrieveMedicalAppointmentByPatientAndDate.retrieve(ssn, dto);
        if (medicalAppointmentOptional.isPresent() 
            && medicalAppointmentOptional.get().getCancellationDate() != null) return ResponseEntity.badRequest().build();

        Optional<MedicalSlot> medicalSlotOptional = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dto);
        if (medicalSlotOptional.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();


        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        if (patient.isEmpty()) return ResponseEntity.badRequest().build();

        MedicalAppointment medicalAppointment = new MedicalAppointment(physician.get(), patient.get(), dto);
        medicalAppointmentRepository.save(medicalAppointment);  

        MedicalSlot medicalSlot = medicalSlotOptional.get();
        medicalSlot.setMedicalAppointment(medicalAppointment);
        medicalSlotRepository.save(medicalSlot);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
