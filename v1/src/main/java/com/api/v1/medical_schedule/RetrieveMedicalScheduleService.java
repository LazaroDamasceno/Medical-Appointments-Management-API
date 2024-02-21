package com.api.v1.medical_schedule;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalScheduleService {

    private final MedicalScheduleRepository medicalScheduleRepository;
    private final PhysicianRepository physicianRepository;

    public ResponseEntity<MedicalSchedule> retrieve(String mln) {
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        return medicalScheduleRepository
                .findByPhysician(physician.get())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}
