package com.api.v4.medical_appointment;

import java.util.List;

import com.api.v4.auxiliaries.BetweenDatesDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-appointments")
@AllArgsConstructor
class RetrieveScheduledMedicalAppointmentsBetweenDatesByPhysicianController {
    
    private final RetrieveSheduledMedicalAppointmentsBetweenDatesByPhysicianService service;

    @GetMapping("between-dates/by-physician/{mln}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrieve(mln, dto);
    }

}
