package com.api.v1.medical_appointment.retrieve_by_user;

import java.time.LocalDateTime;
import java.util.Optional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.ConvertToDateTime;
import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.patient.Patient;
import com.api.v1.patient.retrieve.by_ssn.RetrievePatientBySsnService;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalAppointmentByPatientAndDateService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientBySsnService retrievePatientBySsn;
    private final SystemUserRepository systemUserRepository;

    public Optional<MedicalAppointment> retrieve(String ssn, DateTimeDTO dto) {
        Optional<SystemUser> systemUser = systemUserRepository.findBySsn(ssn);
        if (systemUser.isEmpty()) return Optional.empty();
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        LocalDateTime localDateTime = ConvertToDateTime.convert(dto.dateTime());
        return repository
            .findAll()
            .stream()
            .filter(e -> e.getAvailableDateTime().equals(localDateTime)
                && e.getPatient().equals(patient.get())
            ).findAny();
    }
    
}
