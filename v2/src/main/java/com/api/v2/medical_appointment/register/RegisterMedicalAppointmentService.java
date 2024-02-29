package com.api.v2.medical_appointment.register;

import com.api.v2.dtos.DateTimeDTO;
import com.api.v2.exceptions.MedicalAppointmentAlreadyExistException;
import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import com.api.v2.medical_slot.MedicalSlotRepository;
import com.api.v2.patient.RetrievePatientService;
import com.api.v2.physician.RetrievePhysicianService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.medical_slot.MedicalSlot;
import com.api.v2.medical_slot.RetrieveMedicalSlotService;
import com.api.v2.patient.Patient;
import com.api.v2.physician.Physician;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalAppointmentService {

    private final RetrieveMedicalSlotService retrieveMedicalSlot;
    private final RetrievePhysicianService retrievePhysician;
    private final RetrievePatientService retrievePatient;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final MedicalSlotRepository medicalSlotRepository;

    public ResponseEntity<Void> register(String mln, String ssn, DateTimeDTO dto) {

        Physician physician = retrievePhysician.retrieve(mln);
        Patient patient = retrievePatient.retrieve(ssn);

        boolean doesMedicalAppointmentAlreadyExist = doesMedicalAppointmentAlreadyExist(physician, dto);
        if (doesMedicalAppointmentAlreadyExist) throw new MedicalAppointmentAlreadyExistException();

        MedicalAppointment medicalAppointment = new MedicalAppointment(physician, patient, dto);
        medicalAppointmentRepository.save(medicalAppointment);

        MedicalSlot medicalSlot = retrieveMedicalSlot.retrieve(mln, dto);
        medicalSlot.setMedicalAppointment(medicalAppointment);
        medicalSlotRepository.save(medicalSlot);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private boolean doesMedicalAppointmentAlreadyExist(Physician physician, DateTimeDTO dto) {
        Optional<MedicalAppointment> medicalAppointment = medicalAppointmentRepository
            .findAll()
            .stream()
            .filter(e -> e.getPhysician().equals(physician) 
                && e.getAvailableDateTime().equals(dto.get())
                && e.getCancellationDate() == null
            ).findFirst();
        return medicalAppointment.isPresent();    
    }
    
}
