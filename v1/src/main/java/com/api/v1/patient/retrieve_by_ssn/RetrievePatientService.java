package com.api.v1.patient.retrieve_by_ssn;

import com.api.v1.generics.Retrieve;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.retrieve_by_ssn.RetrieveOptionalOfSystemUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrievePatientService implements Retrieve<ResponseEntity<Patient>, Long> {

    private final PatientRepository repository;
    private final RetrieveOptionalOfSystemUserService retrieveOptionalOfSystemUser;

    @Override
    public ResponseEntity<Patient> retrieve(Long ssn) {
        Optional<SystemUser> systemUserOptional = retrieveOptionalOfSystemUser.retrieve(ssn);
        if (systemUserOptional.isEmpty()) return ResponseEntity.badRequest().build();
        SystemUser systemUser = systemUserOptional.get();
        Optional<Patient> patient = repository.findBySystemUser(systemUser);
        return patient
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
