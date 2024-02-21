package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.ConvertToDateTime;
import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalAppointmentByPatientAndDateService {

    private final MedicalAppointmentRepository repository;
    private final PatientRepository patientRepository;
    private final SystemUserRepository systemUserRepository;

    public Optional<MedicalAppointment> retrieve(String ssn, DateTimeDTO dto) {
        Optional<SystemUser> systemUser = systemUserRepository.findBySsn(ssn);
        if (systemUser.isEmpty()) return Optional.empty();
        Optional<Patient> patient = patientRepository.findBySystemUser(systemUser.get());
        LocalDateTime localDateTime = ConvertToDateTime.convert(dto.dateTime());
        return repository
            .findAll()
            .stream()
            .filter(e -> e.getAvailableDateTime().equals(localDateTime)
                && e.getPatient().equals(patient.get())
            ).findFirst();
    }
    
}
