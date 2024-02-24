package com.api.v1.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.BetweenDatesDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments")
@AllArgsConstructor
public class RetrieveFinishedMedicalAppointmentsBetweenDatesByPatientController {

    private final RetrieveFinishedMedicalAppointmentsBetweenDatesByPatientService service;

    @GetMapping("finished/between-dates/by-patient/{ssn}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable String ssn, @RequestBody BetweenDatesDTO dto) {
        return service.retrieve(ssn, dto);
    }                    
    
}
