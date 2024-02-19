package com.api.v1.medical_schedule.retrieve;

import com.api.v1.generics.Retrieve;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalScheduleService implements Retrieve<ResponseEntity<MedicalSchedule>, Long> {

    private final MedicalScheduleRepository medicalScheduleRepository;
    private final PhysicianRepository physicianRepository;

    @Override
    public ResponseEntity<MedicalSchedule> retrieve(Long mln) {
        Optional<Physician> physician = physicianRepository.findByMln(BigInteger.valueOf(mln));
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        return medicalScheduleRepository
                .findByPhysician(physician.get())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}
