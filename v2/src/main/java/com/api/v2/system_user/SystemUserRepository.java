package com.api.v2.system_user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {

   Optional<SystemUser> findBySsn(String ssn);

}
