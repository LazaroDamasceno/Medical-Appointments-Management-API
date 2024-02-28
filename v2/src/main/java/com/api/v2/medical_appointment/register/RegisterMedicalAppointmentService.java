package com.api.v2.medical_appointment.register;

import java.util.Optional;

import com.api.v2.exceptions.MedicalAppointmentAlreadyExist;
import com.api.v2.exceptions.MedicalSlotNotFound;
import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import com.api.v2.medical_appointment.RetrieveMedicalAppointmentService;
import com.api.v2.medical_slot.MedicalSlotRepository;
import com.api.v2.patient.RetrievePatientService;
import com.api.v2.physician.RetrievePhysicianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.auxiliary.DateTimeDTO;
import com.api.v2.medical_slot.MedicalSlot;
import com.api.v2.medical_slot.RetrieveMedicalSlotService;
import com.api.v2.patient.Patient;
import com.api.v2.physician.Physician;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalAppointmentService {

    private final RetrieveMedicalAppointmentService retrieveMedicalAppointment;
    private final RetrieveMedicalSlotService retrieveMedicalSlot;
    private final RetrievePhysicianService retrievePhysician;
    private final RetrievePatientService retrievePatient;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final MedicalSlotRepository medicalSlotRepository;

    public ResponseEntity<Void> register(String mln, String ssn, DateTimeDTO dto) {

        Physician physician = retrievePhysician.retrieve(mln);
        Patient patient = retrievePatient.retrieve(ssn);

        Optional<MedicalAppointment> medicalAppointmentOptional = Optional.ofNullable(retrieveMedicalAppointment.retrieveByPatient(ssn, dto));
        if (medicalAppointmentOptional.isPresent()) throw new MedicalAppointmentAlreadyExist();

        MedicalAppointment medicalAppointment = new MedicalAppointment(physician, patient, dto);
        medicalAppointmentRepository.save(medicalAppointment);

        MedicalSlot medicalSlot = retrieveMedicalSlot.retrieve(mln, dto);
        medicalSlot.setMedicalAppointment(medicalAppointment);
        medicalSlotRepository.save(medicalSlot);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
