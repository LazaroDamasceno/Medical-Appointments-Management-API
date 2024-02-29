package com.api.v3.medical_slot;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.dtos.DateTimeDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteMedicalRecordService {

    private final RetrieveMedicalSlotService retrieveMedicalSlot;
    private final MedicalSlotRepository repository;

    public ResponseEntity<Void> delete(String mln, DateTimeDTO dto) {
        MedicalSlot medicalSlot = retrieveMedicalSlot.retrieve(mln, dto);
        repository.delete(medicalSlot);
        return ResponseEntity.noContent().build();
    }
    
}
