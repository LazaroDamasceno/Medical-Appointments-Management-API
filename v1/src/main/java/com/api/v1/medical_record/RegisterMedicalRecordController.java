package com.api.v1.medical_record;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-record")
@AllArgsConstructor
public class RegisterMedicalRecordController {
    
    private final RegisterMedicalRecordService service;

    @PostMapping("mln/{mln}/ssn/{ssn}")
    public ResponseEntity<Void> register(@PathVariable String mln, @PathVariable String ssn) {
        return service.register(mln, ssn);
    }

}
