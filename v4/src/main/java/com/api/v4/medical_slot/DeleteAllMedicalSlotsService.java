package com.api.v4.medical_slot;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.physician.Physician;
import com.api.v4.physician.RetrievePhysicianService;
import com.api.v4.auxiliaries.ForbiddenOperationException;

import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
class DeleteAllMedicalSlotsService {

    private final MedicalSlotRepository repository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<Void> delete(@Pattern(regexp = "[0-9]{7}") String mln) {
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
