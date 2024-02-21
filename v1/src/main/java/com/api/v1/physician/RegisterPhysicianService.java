package com.api.v1.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.medical_schedule.MedicalSchedule;

@Service
@AllArgsConstructor
public class RegisterPhysicianService {

    private final PhysicianRepository repository;

    public ResponseEntity<Void> register(RegisterPhysicianDTO dto) {
        Physician physician = new Physician(dto);
        physician.setMedicalSchedule(new MedicalSchedule(physician));
        repository.save(physician);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
