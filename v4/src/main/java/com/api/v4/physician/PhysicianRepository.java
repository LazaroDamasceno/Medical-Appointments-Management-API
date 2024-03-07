package com.api.v4.physician;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface PhysicianRepository extends JpaRepository<Physician, UUID> {

}
