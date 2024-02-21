package com.api.v1.medical_slot;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterMedicalSlotService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;

    public ResponseEntity<Void> register(String mln, DateTimeDTO dateTimeDTO) {
        MedicalSlot medicalSlot = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dateTimeDTO).getBody();
        if (medicalSlot != null) return ResponseEntity.badRequest().build();
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        medicalSlot = new MedicalSlot(physician.get(), dateTimeDTO);
        medicalSlotRepository.save(medicalSlot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
