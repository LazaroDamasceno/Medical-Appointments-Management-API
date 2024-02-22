package com.api.v1.medical_slot.register;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.DateTimeDTO;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class RegisterMedicalSlotController {

    private final RegisterMedicalSlotService service;

    @PostMapping("{mln}")
    public ResponseEntity<Void> register(@PathVariable String mln, @RequestBody DateTimeDTO dateTimeDTO) {
        return service.register(mln, dateTimeDTO);
    }
}
