package com.api.v2.medical_appointment.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@AllArgsConstructor
public class RegisterMedicalAppointmentController {

    private final RegisterMedicalAppointmentService service;

    @PostMapping("mln/{mln}/ssn/{ssn}")
    public ResponseEntity<Void> register(@PathVariable String mln, 
                                         @PathVariable String ssn, 
                                         @RequestBody DateTimeDTO dto) 
    {
        return service.register(mln, ssn, dto);
    }
    
}
