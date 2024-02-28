package com.api.v2.medical_slot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalSlotRepository extends JpaRepository<MedicalSlot, UUID> {
}
