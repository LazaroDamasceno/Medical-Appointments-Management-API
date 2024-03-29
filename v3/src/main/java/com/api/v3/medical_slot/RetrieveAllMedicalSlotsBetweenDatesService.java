package com.api.v3.medical_slot;

import com.api.v3.physician.Physician;
import com.api.v3.physician.PhysicianRepository;
import com.api.v3.auxiliaries.BetweenDatesDTO;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSlotsBetweenDatesService {

    private final MedicalSlotRepository repository;
    private final PhysicianRepository physicianRepository;

    public ResponseEntity<List<MedicalSlot>> retrieveAll(@Pattern(regexp = "[0-9]{7}") String mln, BetweenDatesDTO dto) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(mln);
        if (physicianOptional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = physicianOptional.get();
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
