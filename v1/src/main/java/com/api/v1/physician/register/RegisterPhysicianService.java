package com.api.v1.physician.register;

import com.api.v1.generics.Register;
import com.api.v1.physician.CreateInstanceOfPhysician;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterPhysicianService implements Register<RegisterPhysicianDTO> {

    private final PhysicianRepository repository;

    @Override
    public ResponseEntity<Void> register(RegisterPhysicianDTO dto) {
        Physician physician = CreateInstanceOfPhysician.create(dto);
        repository.save(physician);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
