package com.api.v1.medical_schedule;

import com.api.v1.physician.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MedicalScheduleRepository extends JpaRepository<MedicalSchedule, UUID> {

    Optional<MedicalSchedule> findByPhysician(Physician physician);

}
