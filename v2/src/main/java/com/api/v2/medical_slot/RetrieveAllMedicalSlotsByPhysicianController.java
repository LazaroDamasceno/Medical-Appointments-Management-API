package com.api.v2.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/medical-slots")
public class RetrieveAllMedicalSlotsByPhysicianController {

    private final RetrieveAllMedicalSlotsByPhysicianService service;

    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln) {
        return service.retrieveAll(mln);
    }
}
