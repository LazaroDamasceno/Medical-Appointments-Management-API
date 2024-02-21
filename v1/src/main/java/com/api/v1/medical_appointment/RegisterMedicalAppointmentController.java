package com.api.v1.medical_appointment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@AllArgsConstructor
public class RegisterMedicalAppointmentController {

    private final RegisterMedicalAppointmentService service;

    public ResponseEntity<Void> register(String mln, String ssn, DateTimeDTO dto) {
        return service.register(mln, ssn, dto);
    }
    
}
