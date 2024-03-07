package com.api.v4.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-appointments")
@AllArgsConstructor
class RetrieveCancelledMedicalAppointmentsByPatientController {

    private final RetrieveCancelledMedicalAppointmentsByPatientService service;

    @GetMapping("cancelled/by-patient/{ssn}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable @Pattern(regexp = "[0-9]{9}") String ssn) {
        return service.retrieve(ssn);
    }                   
    
}
