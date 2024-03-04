package com.api.v4.medical_appointment.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import com.api.v4.auxiliaries.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-appointment")
@AllArgsConstructor
public class RegisterMedicalAppointmentController {

    private final RegisterMedicalAppointmentService service;

    @PostMapping("mln/{mln}/ssn/{ssn}")
    public ResponseEntity<Void> register(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, 
                                         @PathVariable @Pattern(regexp = "[0-9]{9}") String ssn, 
                                         @RequestBody DateTimeDTO dto) 
    {
        return service.register(mln, ssn, dto);
    }
    
}
