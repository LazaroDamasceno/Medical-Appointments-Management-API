package com.api.v1.medical_slot;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSlotBetweenDatesService {

    private final MedicalSlotRepository repository;
    private final PhysicianRepository physicianRepository;

    public ResponseEntity<List<MedicalSlot>> retrieveAll(String mln, 
                                                        LocalDateTime firstDate, 
                                                        LocalDateTime lastDate) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(mln);
        if (physicianOptional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = physicianOptional.get();
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician)
                            && e.getAvailableDateTime().isAfter(firstDate)
                            && e.getAvailableDateTime().isBefore(lastDate))
                        .toList()
        );
    }
}
