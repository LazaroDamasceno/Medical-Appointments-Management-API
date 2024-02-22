package com.api.v1.medical_appointment;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.v1.auxiliary.BetweenDatesDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments")
@AllArgsConstructor
public class RetrieveAllMedicalAppointmentsBetweenDatesByPhysicianController {
    
    private final RetrieveAllMedicalAppointmentsBetweenDatesByPhysicianService service;

    @GetMapping("between-dates/{mln}")
    ResponseEntity<List<MedicalAppointment>> retrive(@PathVariable String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrive(mln, dto);
    }

}
