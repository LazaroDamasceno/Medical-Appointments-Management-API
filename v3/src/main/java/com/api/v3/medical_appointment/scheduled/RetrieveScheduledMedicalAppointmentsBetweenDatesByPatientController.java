package com.api.v3.medical_appointment.scheduled;

import java.util.List;

import com.api.v3.dtos.BetweenDatesDTO;
import com.api.v3.medical_appointment.MedicalAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v3/medical-appointments")
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsBetweenDatesByPatientController {

    private final RetrieveScheduledMedicalAppointmentsBetweenDatesByPatientService service;

    @GetMapping("scheduled/between-dates/by-patient/{ssn}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable String ssn, @RequestBody BetweenDatesDTO dto) {
        return service.retrieve(ssn, dto);
    }                   
    
}
