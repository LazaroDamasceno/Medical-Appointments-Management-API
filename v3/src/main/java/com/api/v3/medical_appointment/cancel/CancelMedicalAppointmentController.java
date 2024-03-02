package com.api.v3.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v3.auxiliaries.DateTimeDTO;

import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v3/medical-appointment")
@AllArgsConstructor
public class CancelMedicalAppointmentController {
    
    private final CancelMedicalAppointmentService service;

    @PatchMapping("{ssn}")
    public ResponseEntity<Void> cancel(@PathVariable @Pattern(regexp = "[0-9]{9}") String ssn, @RequestBody DateTimeDTO dto) {
        return service.cancel(ssn, dto);
    }

}
