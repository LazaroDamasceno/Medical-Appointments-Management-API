package com.api.v2.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v2.dtos.DateTimeDTO;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/medical-appointment")
@AllArgsConstructor
public class CancelMedicalAppointmentController {
    
    private final CancelMedicalAppointmentService service;

    @PatchMapping("{ssn}")
    public ResponseEntity<Void> cancel(@PathVariable String ssn, @RequestBody DateTimeDTO dto) {
        return service.cancel(ssn, dto);
    }

}
