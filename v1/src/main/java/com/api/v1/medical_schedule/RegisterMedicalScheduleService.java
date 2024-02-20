package com.api.v1.medical_schedule;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterMedicalScheduleService {

    private final PhysicianRepository physicianRepository;

    public void register(Physician physician) {
        MedicalSchedule medicalSchedule = new MedicalSchedule(physician);
        physician.setMedicalSchedule(medicalSchedule);
        physicianRepository.save(physician);
    }
}
