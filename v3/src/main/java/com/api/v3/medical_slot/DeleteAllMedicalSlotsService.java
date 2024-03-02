package com.api.v3.medical_slot;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;
import com.api.v3.auxiliaries.ForbiddenOperationException;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteAllMedicalSlotsService {

    private final MedicalSlotRepository repository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<Void> delete(@Pattern(regexp = "[//d]{7}") String mln) {
        Physician physician = retrievePhysician.retrieve(mln);
        List<MedicalSlot> medicalSlots = repository
            .findAll()
            .stream()
            .filter(e -> e.getMedicalAppointment() == null 
                && e.getPhysician().equals(physician)    
            )
            .toList();
        if (medicalSlots == null) throw new ForbiddenOperationException();
        repository.deleteAll(medicalSlots);
        return ResponseEntity.noContent().build();
    }    
    
}
