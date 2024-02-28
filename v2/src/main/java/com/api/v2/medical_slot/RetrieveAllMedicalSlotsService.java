package com.api.v2.medical_slot;

import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSlotsService {

    private final MedicalSlotRepository repository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<List<MedicalSlot>> retrieveAll(String mln) {
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
