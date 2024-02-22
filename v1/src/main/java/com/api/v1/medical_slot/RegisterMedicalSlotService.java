package com.api.v1.medical_slot;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterMedicalSlotService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;

    public ResponseEntity<Void> register(String mln, LocalDateTime dateTime) {
        Optional<MedicalSlot> medicalSlotOptional = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dateTime);
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (medicalSlotOptional.isPresent() || physician.isEmpty()) return ResponseEntity.badRequest().build();
        medicalSlotRepository.save(new MedicalSlot(physician.get(), dateTime));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
