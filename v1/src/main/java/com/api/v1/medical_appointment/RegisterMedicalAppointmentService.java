package com.api.v1.medical_appointment;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalAppointmentService {

    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrievePatientBySsnService retrievePatientBySsn;
    private final MedicalAppointmentRepository repository;
    private final RetrieveMedicalAppointmentByPatientAndDateService retrieveMedicalAppointmentByPatientAndDate;

    public ResponseEntity<Void> register(String mln, String ssn, DateTimeDTO dto) {
        Optional<MedicalAppointment> medicalAppointmentOptional = retrieveMedicalAppointmentByPatientAndDate.retrieve(ssn, dto);
        if (medicalAppointmentOptional.isPresent()) return ResponseEntity.badRequest().build();

        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        if (physician.isEmpty() || patient.isEmpty()) return ResponseEntity.badRequest().build();

        MedicalAppointment medicalAppointment = new MedicalAppointment(physician.get(), patient.get(), dto);
        repository.save(medicalAppointment);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
