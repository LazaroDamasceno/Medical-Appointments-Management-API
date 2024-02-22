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
public class RetrieveAllMedicalAppointmentsBetweenDatesByPhysicianController {
    
    private final RetrieveAllMedicalAppointmentsBetweenDatesByPhysicianService service;

    @GetMapping("between-dates/{mln}/{firstDate}/{lastDate}")
    ResponseEntity<List<MedicalAppointment>> retrive(@PathVariable String mln, 
                                                    @PathVariable LocalDateTime firstDate,
                                                    @PathVariable LocalDateTime lastDate) {
        return service.retrive(mln, firstDate, lastDate);
    }

}
