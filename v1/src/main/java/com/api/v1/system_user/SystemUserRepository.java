package com.api.v1.system_user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {

   SystemUser getBySsn(String ssn);

}
