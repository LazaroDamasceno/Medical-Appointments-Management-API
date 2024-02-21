package com.api.v1.medical_appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalAppointmentsByPatientService {

    private final MedicalAppointmentRepository repository;
    private final PatientRepository patientRepository;
    private final SystemUserRepository systemUserRepository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String ssn) {
        Optional<SystemUser> systemUser = systemUserRepository.findBySsn(ssn);
        if (systemUser.isEmpty()) return ResponseEntity.badRequest().build();
        Optional<Patient> patient = patientRepository.findBySystemUser(systemUser.get());
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPatient().equals(patient.get()))
                .toList()
        );
    }
    
}
