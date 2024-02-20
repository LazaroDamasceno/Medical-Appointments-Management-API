package com.api.v1.physician;

import com.api.v1.medical_schedule.RegisterMedicalScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterPhysicianService {

    private final PhysicianRepository repository;
    private final RegisterMedicalScheduleService registerMedicalSchedule;

    public ResponseEntity<Void> register(RegisterPhysicianDTO dto) {
        Physician physician = CreateInstanceOfPhysician.create(dto);
        repository.save(physician);
        registerMedicalSchedule.register(physician);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
