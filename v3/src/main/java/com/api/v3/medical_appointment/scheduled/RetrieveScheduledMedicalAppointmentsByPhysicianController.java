package com.api.v3.medical_appointment.scheduled;

import java.util.List;

import com.api.v3.medical_appointment.MedicalAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v3/medical-appointments/scheduled")
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsByPhysicianController {
    
    private final RetrieveScheduledMedicalAppointmentsByPhysicianService service;

    @GetMapping("by-physician/{mln}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln) {
        return service.retrieve(mln);
    }

}
