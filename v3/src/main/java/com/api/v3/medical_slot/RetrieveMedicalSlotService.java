package com.api.v3.medical_slot;

import com.api.v3.dtos.DateTimeDTO;
import com.api.v3.exceptions.MedicalSlotNotFoundException;
import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalSlotService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final RetrievePhysicianService retrievePhysician;

    public MedicalSlot retrieve(String mln, DateTimeDTO dto) {
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
