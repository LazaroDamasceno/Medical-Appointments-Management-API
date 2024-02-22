package com.api.v1.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSlotsService {

    private final MedicalSlotRepository repository;

    public ResponseEntity<List<MedicalSlot>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
