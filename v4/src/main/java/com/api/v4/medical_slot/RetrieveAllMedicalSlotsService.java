package com.api.v4.medical_slot;

import com.api.v4.physician.Physician;
import com.api.v4.physician.RetrievePhysicianService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSlotsService {

    private final MedicalSlotRepository repository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<List<MedicalSlot>> retrieveAll(@Pattern(regexp = "[0-9]{7}") String mln) {
        Physician physician = retrievePhysician.retrieve(mln);
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician))
                        .toList()
        );
    }
}
