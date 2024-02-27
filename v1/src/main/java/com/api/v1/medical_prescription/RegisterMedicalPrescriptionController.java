package com.api.v1.medical_prescription;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-prescription")
@AllArgsConstructor
public class RegisterMedicalPrescriptionController {

    private final RegisterMedicalPrescriptionService service;

    @GetMapping("mln/{mln}/ssn/{ssn}")
    public ResponseEntity<Void> register(@PathVariable String mln, 
                                         @PathVariable String ssn, 
                                         @RequestBody DateTimeDTO dateTime, 
                                         @RequestBody MedicalPrescriptionDTO prescription) {
        return service.register(mln, ssn, dateTime, prescription);
    }
    
}
