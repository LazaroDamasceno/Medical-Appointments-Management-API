package com.api.v1.medical_slot.retrieve.between_dates;

import com.api.v1.auxiliary.BetweenDatesDTO;
import com.api.v1.auxiliary.ConvertToDateTime;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.MedicalSlotRepository;
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

    public ResponseEntity<List<MedicalSlot>> retrieveAll(String mln, BetweenDatesDTO dto) {
        LocalDateTime fdt = ConvertToDateTime.convert(dto.firstDate());
        LocalDateTime ldt = ConvertToDateTime.convert(dto.lastDate());
        Optional<Physician> physicianOptional = physicianRepository.findByMln(mln);
        if (physicianOptional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = physicianOptional.get();
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician)
                        && e.getAvailableDateTime().isAfter(fdt)
                        && e.getAvailableDateTime().isBefore(ldt))
                        .toList()
        );
    }
}
