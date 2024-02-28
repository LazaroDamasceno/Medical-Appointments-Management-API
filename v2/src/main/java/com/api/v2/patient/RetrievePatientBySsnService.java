package com.api.v2.patient;

import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientBySsnService {

    private final PatientRepository repository;
    private final SystemUserRepository systemUserRepository;

    public Optional<Patient> retrieve(String ssn) {
        Optional<SystemUser> systemUser = systemUserRepository.findBySsn(ssn);
        if (systemUser.isEmpty()) return Optional.empty();
        return repository
            .findAll()
            .stream()
            .filter(e -> e.getSystemUser().equals(systemUser.get()))
            .findAny();
    }

}
