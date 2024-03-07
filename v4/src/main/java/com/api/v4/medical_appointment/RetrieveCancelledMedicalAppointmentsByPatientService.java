package com.api.v4.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.Pattern;

import com.api.v4.patient.Patient;
import com.api.v4.patient.RetrievePatientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class RetrieveCancelledMedicalAppointmentsByPatientService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientService retrievePatientBySsn;

    public ResponseEntity<List<MedicalAppointment>> retrieve(@Pattern(regexp = "[0-9]{9}") String ssn) {
        Patient patient = retrievePatientBySsn.retrieve(ssn);
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPatient().equals(patient)
                                && e.getCancellationDate() != null
                        )
                        .toList()
        );
    }
    
}
