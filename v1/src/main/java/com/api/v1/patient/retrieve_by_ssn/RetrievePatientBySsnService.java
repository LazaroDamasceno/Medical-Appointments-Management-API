package com.api.v1.patient.retrieve_by_ssn;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientBySsnService {

    private final PatientRepository repository;
    private final SystemUserRepository systemUserRepository;

    public ResponseEntity<Patient> retrieve(String ssn) {
        Optional<SystemUser> systemUserOptional = systemUserRepository.findBySsn(new BigInteger(ssn));
        if (systemUserOptional.isEmpty()) return ResponseEntity.badRequest().build();
        SystemUser systemUser = systemUserOptional.get();
        Optional<Patient> patient = repository.findBySystemUser(systemUser);
        return patient
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
