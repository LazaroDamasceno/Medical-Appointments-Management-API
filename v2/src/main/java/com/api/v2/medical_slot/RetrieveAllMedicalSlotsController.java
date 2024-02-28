package com.api.v2.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v2/medical-slots")
@AllArgsConstructor
public class RetrieveAllMedicalSlotsController {

    private final RetrieveAllMedicalSlotsService service;

    public ResponseEntity<List<MedicalSlot>> retriveAll() {
        return service.retriveAll();
    }
}
