package com.api.v1.physician.register;

import com.api.v1.generic_interfaces.register.with_response_entity.RegisterWithOneParameter;
import com.api.v1.medical_schedule.register.RegisterWithOneParameterMedicalScheduleService;
import com.api.v1.physician.CreateInstanceOfPhysician;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterWithOneParameterPhysicianService implements RegisterWithOneParameter<RegisterPhysicianDTO> {

    private final PhysicianRepository repository;
    private final RegisterWithOneParameterMedicalScheduleService registerMedicalSchedule;

    @Override
    public ResponseEntity<Void> register(RegisterPhysicianDTO dto) {
        Physician physician = CreateInstanceOfPhysician.create(dto);
        repository.save(physician);
        registerMedicalSchedule.register(physician);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
