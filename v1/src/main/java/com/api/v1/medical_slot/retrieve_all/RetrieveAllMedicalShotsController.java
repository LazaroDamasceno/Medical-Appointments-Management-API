package com.api.v1.medical_slot.retrieve_all;

import com.api.v1.medical_slot.MedicalSlot;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/medical-slots")
@AllArgsConstructor
public class RetrieveAllMedicalShotsController {

    private final RetrieveAllMedicalShotsService service;

    public ResponseEntity<List<MedicalSlot>> retriveAll() {
        return service.retriveAll();
    }
}
