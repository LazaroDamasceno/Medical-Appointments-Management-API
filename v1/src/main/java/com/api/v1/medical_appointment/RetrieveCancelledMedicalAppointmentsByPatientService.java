package com.api.v1.medical_appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveCancelledMedicalAppointmentsByPatientService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientBySsnService retrievePatientBySsn;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String ssn) {
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        if (patient.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPatient().equals(patient.get())
                    && e.getCancelationDateTime() != null
                )
                .toList()
        );
    }
    
}
