package com.api.v3.medical_slot;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.auxiliaries.DateTimeDTO;
import com.api.v3.auxiliaries.ForbiddenOperationException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteMedicalRecordService {

    private final RetrieveMedicalSlotService retrieveMedicalSlot;
    private final MedicalSlotRepository repository;

    public ResponseEntity<Void> delete(@Pattern(regexp = "[0-9]{7}") String mln, DateTimeDTO dto) {
        MedicalSlot medicalSlot = retrieveMedicalSlot.retrieve(mln, dto);
        if (medicalSlot.getMedicalAppointment() != null) throw new ForbiddenOperationException();
        repository.delete(medicalSlot);
        return ResponseEntity.noContent().build();
    }
    
}
