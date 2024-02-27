package com.api.v1.medical_appointment;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalAppointmentByPatientAndDateService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientBySsnService retrievePatientBySsn;

    public Optional<MedicalAppointment> retrieve(String ssn, DateTimeDTO dto) {
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        return patient.flatMap(value -> repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(dto.get())
                        && e.getPatient().equals(value)
                ).findAny());
    }
    
}
