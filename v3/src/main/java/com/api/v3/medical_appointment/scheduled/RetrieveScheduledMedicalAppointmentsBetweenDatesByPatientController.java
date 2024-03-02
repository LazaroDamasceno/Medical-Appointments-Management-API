package com.api.v3.medical_appointment.scheduled;

import java.util.List;

import com.api.v3.medical_appointment.MedicalAppointment;
import com.api.v3.auxiliaries.BetweenDatesDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("api/v3/medical-appointments")
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsBetweenDatesByPatientController {

    private final RetrieveScheduledMedicalAppointmentsBetweenDatesByPatientService service;

    @GetMapping("scheduled/between-dates/by-patient/{ssn}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable @Pattern(regexp = "[//d]{9}") String ssn, @RequestBody BetweenDatesDTO dto) {
        return service.retrieve(ssn, dto);
    }                   
    
}
