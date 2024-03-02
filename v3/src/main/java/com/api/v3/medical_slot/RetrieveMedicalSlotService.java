package com.api.v3.medical_slot;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;
import com.api.v3.auxiliaries.DateTimeDTO;
import com.api.v3.auxiliaries.MedicalSlotNotFoundException;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
public class RetrieveMedicalSlotService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final RetrievePhysicianService retrievePhysician;

    public MedicalSlot retrieve(@Pattern(regexp = "[//d]{7}") String mln, DateTimeDTO dto) {
        Physician physician = retrievePhysician
.retrieve(mln);
        Optional<MedicalSlot> medicalSlot = medicalSlotRepository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician) 
                    && e.getAvailableDateTime().equals(dto.get())
                ).findAny();
        if (medicalSlot.isEmpty()) throw new MedicalSlotNotFoundException();
        return medicalSlot.get();
    }

}
