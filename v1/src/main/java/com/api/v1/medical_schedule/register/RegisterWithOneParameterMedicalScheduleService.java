package com.api.v1.medical_schedule.register;

import com.api.v1.generic_interfaces.register.RegisterWithOneParameter;
import com.api.v1.medical_schedule.CreateInstanceOfMedicalSchedule;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import com.api.v1.physician.Physician;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterWithOneParameterMedicalScheduleService implements RegisterWithOneParameter<Physician> {

    private final MedicalScheduleRepository repository;

    @Override
    public ResponseEntity<Void> register(Physician physician) {
        MedicalSchedule medicalSchedule = CreateInstanceOfMedicalSchedule.create(physician);
        repository.save(medicalSchedule);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
