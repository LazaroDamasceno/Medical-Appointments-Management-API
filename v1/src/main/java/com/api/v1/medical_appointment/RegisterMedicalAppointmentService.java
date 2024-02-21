package com.api.v1.medical_appointment;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.MedicalSlotRepository;
import com.api.v1.medical_slot.RetrieveMedicalSlotByDateAndPhysicianService;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalAppointmentService {

    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final SystemUserRepository systemUserRepository;
    private final PatientRepository patientRepository;
    private final PhysicianRepository physicianRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;
    private final MedicalSlotRepository medicalSlotRepository;

    public ResponseEntity<Void> register(String mln, String ssn, DateTimeDTO dto) {
        Optional<MedicalSlot> medicalSlotOptional = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dto);
        if (medicalSlotOptional.isEmpty()) return ResponseEntity.badRequest().build();

        SystemUser systemUser = systemUserRepository.getBySsn(ssn);
        Optional<Patient> patient = patientRepository.findBySystemUser(systemUser);
        if (patient.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();

        MedicalAppointment medicalAppointment = new MedicalAppointment(physician.get(), patient.get(), dto);
        medicalAppointmentRepository.save(medicalAppointment);  
        MedicalSlot medicalSlot = medicalSlotOptional.get();

        medicalSlot.setMedicalAppointment(medicalAppointment);
        medicalSlotRepository.save(medicalSlot);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
