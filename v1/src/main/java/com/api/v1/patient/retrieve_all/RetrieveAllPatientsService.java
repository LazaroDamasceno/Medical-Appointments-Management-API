package com.api.v1.patient.retrieve_all;

import com.api.v1.generics.RetrieveAll;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.system_user.register.RegisterSystemUserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllPatientsService implements RetrieveAll<Patient> {

    private final PatientRepository repository;

    @Override
    public ResponseEntity<List<Patient>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
