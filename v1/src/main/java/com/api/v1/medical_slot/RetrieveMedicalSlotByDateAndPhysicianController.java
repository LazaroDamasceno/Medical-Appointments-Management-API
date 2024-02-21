package com.api.v1.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.v1.auxiliary.DateTimeDTO;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class RetrieveMedicalSlotByDateAndPhysicianController {

    private final RetrieveMedicalSlotByDateAndPhysicianService service;

    @GetMapping("{mln}")
    public ResponseEntity<MedicalSlot> retrieve(@PathVariable String mln, @RequestBody DateTimeDTO dateTimeDTO) {
        return service.retrieve(mln, dateTimeDTO);
    }
}
