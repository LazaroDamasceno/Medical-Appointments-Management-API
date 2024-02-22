package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
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
public class RetrieveAllMedicalAppointmentsBetweenDatesByPatientController {

    private final RetrieveAllMedicalAppointmentsBetweenDatesByPatientService service;

    @GetMapping("between-dates/{ssn}/{firstDate}/{lastDate}")
    ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable String ssn, 
                                                    @PathVariable LocalDateTime firstDate,
                                                    @PathVariable LocalDateTime lastDate) {
        return service.retrieve(ssn, firstDate, lastDate);
    }

}
