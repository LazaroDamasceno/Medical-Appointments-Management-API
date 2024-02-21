package com.api.v1.patient;

import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientBySsnService {

    private final PatientRepository repository;
    private final SystemUserRepository systemUserRepository;

    public ResponseEntity<Patient> retrieve(String ssn) {
        SystemUser systemUser = systemUserRepository.getBySsn(ssn);
        Optional<Patient> patient = repository.findBySystemUser(systemUser);
        return patient
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
