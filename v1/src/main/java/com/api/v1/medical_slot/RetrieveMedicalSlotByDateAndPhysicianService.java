package com.api.v1.medical_slot;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalSlotByDateAndPhysicianService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;

    public Optional<MedicalSlot> retrieve(String mln, LocalDateTime dateTime) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(mln);
        if (physicianOptional.isEmpty()) return Optional.empty();
        Physician physician = physicianOptional.get();
        return medicalSlotRepository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician) 
                    && e.getAvailableDateTime().equals(dateTime)
                ).findAny();
    }
}
