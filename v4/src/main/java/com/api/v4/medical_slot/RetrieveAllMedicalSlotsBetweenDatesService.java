package com.api.v4.medical_slot;

import com.api.v4.physician.Physician;
import com.api.v4.physician.RetrievePhysicianService;
import com.api.v4.auxiliaries.BetweenDatesDTO;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
class RetrieveAllMedicalSlotsBetweenDatesService {

    private final MedicalSlotRepository repository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<List<MedicalSlot>> retrieveAll(@Pattern(regexp = "[0-9]{7}") String mln, BetweenDatesDTO dto) {
        Physician physician = retrievePhysician.retrieve(mln);
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician)
                        && e.getAvailableDateTime().isAfter(dto.getFirstDate())
                        && e.getAvailableDateTime().isBefore(dto.getLastDate()))
                        .toList()
        );
    }
}
