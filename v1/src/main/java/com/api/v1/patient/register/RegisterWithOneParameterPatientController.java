package com.api.v1.patient.register;

import com.api.v1.generic_interfaces.register.RegisterWithOneParameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/patient")
@AllArgsConstructor
public class RegisterWithOneParameterPatientController implements RegisterWithOneParameter<RegisterPatientDTO> {

    private final RegisterWithOneParameterPatientService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterPatientDTO dto) {
        return service.register(dto);
    }

}
