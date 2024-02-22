package com.api.v1.medical_slot;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class RegisterMedicalSlotController {

    private final RegisterMedicalSlotService service;

    @PostMapping("{mln}/{dateTime}")
    public ResponseEntity<Void> register(@PathVariable String mln, @PathVariable LocalDateTime dateTime) {
        return service.register(mln, dateTime);
    }
}
