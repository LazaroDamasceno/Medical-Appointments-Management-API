package com.api.v1.medical_slot;

import com.api.v1.auxiliary.ConvertToDateTime;
import com.api.v1.auxiliary.DateTimeDTO;
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

    public Optional<MedicalSlot> retrieve(String mln, DateTimeDTO dateTimeDTO) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(mln);
        if (physicianOptional.isEmpty()) return Optional.empty();
        Physician physician = physicianOptional.get();
        LocalDateTime dateTime = ConvertToDateTime.convert(dateTimeDTO.dateTime());
        return medicalSlotRepository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician) 
                    && e.getAvailableDateTime().equals(dateTime)
                ).findFirst();
    }
}
