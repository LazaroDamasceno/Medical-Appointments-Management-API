package com.api.v4.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("api/v4/medical-appointments/scheduled")
@AllArgsConstructor
class RetrieveScheduledMedicalAppointmentsByPhysicianController {
    
    private final RetrieveScheduledMedicalAppointmentsByPhysicianService service;

    @GetMapping("by-physician/{mln}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln) {
        return service.retrieve(mln);
    }

}
