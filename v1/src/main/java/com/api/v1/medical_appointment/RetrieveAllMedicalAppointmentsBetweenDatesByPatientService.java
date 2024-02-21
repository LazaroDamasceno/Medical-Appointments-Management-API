package com.api.v1.medical_appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.BetweenDatesDTO;
import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalAppointmentsBetweenDatesByPatientService {

    private final MedicalAppointmentRepository repository;
    private final SystemUserRepository systemUserRepository;
    private final RetrievePatientBySsnService retrievePatientBySsn;

    ResponseEntity<List<MedicalAppointment>> retrieve(String ssn, BetweenDatesDTO dto) {
        Optional<SystemUser> systemUser = systemUserRepository.findBySsn(ssn);
        if (systemUser.isEmpty()) return ResponseEntity.badRequest().build();
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().isAfter(dto.firstDate())
                    && e.getAvailableDateTime().isBefore(dto.lastDate())
                    && e.getPatient().equals(patient.get())
                ).toList()
        );
    }
    
}
