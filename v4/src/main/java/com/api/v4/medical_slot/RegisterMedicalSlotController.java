package com.api.v4.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Pattern;

import com.api.v4.auxiliaries.DateTimeDTO;

@RestController
@RequestMapping("api/v4/medical-slot")
@AllArgsConstructor
class RegisterMedicalSlotController {

    private final RegisterMedicalSlotService service;

    @PostMapping("{mln}")
    public ResponseEntity<Void> register(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, @RequestBody DateTimeDTO dateTimeDTO) {
        return service.register(mln, dateTimeDTO);
    }
}
