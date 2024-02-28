package com.api.v2.medical_slot;

import com.api.v2.auxiliary.DateTimeDTO;
import com.api.v2.physician.Physician;
import com.api.v2.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalSlotByDateAndPhysicianService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;

    public Optional<MedicalSlot> retrieve(String mln, DateTimeDTO dto) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(mln);
        if (physicianOptional.isEmpty()) return Optional.empty();
        Physician physician = physicianOptional.get();
        return medicalSlotRepository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician) 
                    && e.getAvailableDateTime().equals(dto.get())
                ).findAny();
    }
}
