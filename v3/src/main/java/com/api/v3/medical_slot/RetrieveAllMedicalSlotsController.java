package com.api.v3.medical_slot;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-slots")
@AllArgsConstructor
public class RetrieveAllMedicalSlotsController {

    private final RetrieveAllMedicalSlotsService service;

    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln) {
        return service.retrieveAll(mln);
    }
    
}
