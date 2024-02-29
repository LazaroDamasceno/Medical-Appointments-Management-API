package com.api.v3.medical_slot;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteAllMedicalSlotsService {

    private final MedicalSlotRepository repository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<Void> delete(String mln) {
        Physician physician = retrievePhysician.retrieve(mln);
        List<MedicalSlot> medicalSlots = repository
            .findAll()
            .stream()
            .filter(e -> e.getMedicalAppointment() != null 
                && e.getPhysician().equals(physician)    
            )
            .toList();
        repository.deleteAll(medicalSlots);
        return ResponseEntity.noContent().build();
    }    
    
}
