package com.api.v4.medical_appointment.cancelled;

import java.util.List;

import com.api.v4.medical_appointment.MedicalAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-appointments/cancelled")
@AllArgsConstructor
class RetrieveCancelledMedicalAppointmentsByPhysicianController {

    private final RetrieveCancelledMedicalAppointmentsByPhysicianService service;

    @GetMapping("by-physician/{mln}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln) {
        return service.retrieve(mln);
    }
    
}
