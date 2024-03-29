package com.api.v2.medical_appointment.scheduled;

import java.util.List;

import com.api.v2.dtos.BetweenDatesDTO;
import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.patient.Patient;
import com.api.v2.patient.RetrievePatientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsBetweenDatesByPatientService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientService retrievePatientBySsn;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String ssn, BetweenDatesDTO dto) {
        Patient patient = retrievePatientBySsn.retrieve(ssn);
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPatient().equals(patient)
                    && e.getCancellationDate() == null
                    && e.getAvailableDateTime().isAfter(dto.getFirstDate())
                    && e.getAvailableDateTime().isBefore(dto.getLastDate())
                )
                .toList()
        );
    }
    
}
