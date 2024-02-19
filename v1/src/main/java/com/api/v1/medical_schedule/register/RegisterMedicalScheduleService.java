package com.api.v1.medical_schedule.register;

import com.api.v1.generics.Register;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterMedicalScheduleService implements Register<MedicalSchedule> {

    private final MedicalScheduleRepository repository;

    @Override
    public ResponseEntity<Void> register(MedicalSchedule dto) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
