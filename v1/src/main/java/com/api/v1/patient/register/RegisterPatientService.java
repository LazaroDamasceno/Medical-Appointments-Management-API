package com.api.v1.patient.register;

import com.api.v1.generic_interfaces.register.with_response_entity.RegisterWithOneParameter;
import com.api.v1.patient.CreateInstanceOfPatient;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterPatientService implements RegisterWithOneParameter<RegisterPatientDTO> {

    private final PatientRepository repository;

    @Override
    public ResponseEntity<Void> register(RegisterPatientDTO dto) {
        Patient patient = CreateInstanceOfPatient.create(dto);
        repository.save(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
