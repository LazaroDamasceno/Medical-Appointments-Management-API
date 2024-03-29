package com.api.v2.medical_appointment.scheduled;

import java.util.List;

import com.api.v2.dtos.BetweenDatesDTO;
import com.api.v2.medical_appointment.MedicalAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/medical-appointments")
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsBetweenDatesByPhysicianController {
    
    private final RetrieveSheduledMedicalAppointmentsBetweenDatesByPhysicianService service;

    @GetMapping("between-dates/by-physician/{mln}")
    public ResponseEntity<List<MedicalAppointment>> retrieve(@PathVariable String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrieve(mln, dto);
    }

}
