package com.api.v1.patient;

import com.api.v1.system_user.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findBySystemUser(SystemUser systemUser);

}
