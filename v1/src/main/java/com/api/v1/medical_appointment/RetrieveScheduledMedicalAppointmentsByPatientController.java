package com.api.v1.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments")
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsByPatientController {

    private final RetrieveScheduledMedicalAppointmentsByPatientService service;

    @GetMapping("scheduled/by-patient/{ssn}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable String ssn) {
        return service.retrieve(ssn);
    }                   
    
}
