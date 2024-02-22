package com.api.v1.medical_slot.retrieve.by_physician;

import com.api.v1.medical_slot.MedicalSlot;
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
