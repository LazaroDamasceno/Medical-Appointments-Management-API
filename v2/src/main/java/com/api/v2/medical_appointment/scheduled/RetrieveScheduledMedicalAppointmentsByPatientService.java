package com.api.v2.medical_appointment.scheduled;

import java.util.List;

import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.patient.Patient;
import com.api.v2.patient.RetrievePatientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsByPatientService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientService retrievePatientBySsn;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String ssn) {
        Patient patient = retrievePatientBySsn.retrieve(ssn);
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPatient().equals(patient)
                                && e.getCancellationDate() == null
                        )
                        .toList()
        );
    }
    
}
