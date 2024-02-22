package com.api.v1.medical_appointment;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@AllArgsConstructor
public class RegisterMedicalAppointmentController {

    private final RegisterMedicalAppointmentService service;

    @PostMapping("{mln}/{ssn}/{dateTime}")
    public ResponseEntity<Void> register(@PathVariable String mln, 
                                         @PathVariable String ssn, 
                                         @PathVariable LocalDateTime dateTime) 
    {
        return service.register(mln, ssn, dateTime);
    }
    
}
