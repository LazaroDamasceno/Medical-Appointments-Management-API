package com.api.v1.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/cancelled")
@AllArgsConstructor
public class RetrieveCancelledMedicalAppointmentsByPhysicianController {

    private final RetrieveCancelledMedicalAppointmentsByPhysicianService service;

    @GetMapping("by-physician/{mln}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable String mln) {
        return service.retrieve(mln);
    }
    
}
