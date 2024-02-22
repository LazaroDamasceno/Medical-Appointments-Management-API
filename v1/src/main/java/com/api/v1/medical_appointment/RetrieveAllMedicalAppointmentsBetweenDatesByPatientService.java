package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalAppointmentsBetweenDatesByPatientService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientBySsnService retrievePatientBySsn;

    ResponseEntity<List<MedicalAppointment>> retrieve(String mln, 
                                                    LocalDateTime firstDate,
                                                    LocalDateTime lastDate) {
        Optional<Patient> patient = retrievePatientBySsn.retrieve(mln);
        if (patient.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().isAfter(firstDate)
                    && e.getAvailableDateTime().isBefore(lastDate)
                    && e.getPatient().equals(patient.get())
                ).toList()
        );
    }
    
}
