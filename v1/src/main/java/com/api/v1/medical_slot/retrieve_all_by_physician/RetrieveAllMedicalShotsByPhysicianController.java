package com.api.v1.medical_slot.retrieve_all_by_physician;

import com.api.v1.generic_interfaces.retrieve_all.RetrieveAllWithOneParameter;
import com.api.v1.medical_slot.MedicalSlot;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/medical-slots")
public class RetrieveAllMedicalShotsByPhysicianController implements RetrieveAllWithOneParameter<MedicalSlot, String> {

    private final RetrieveAllMedicalShotsByPhysicianService service;

    @Override
    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln) {
        return service.retrieveAll(mln);
    }
}
