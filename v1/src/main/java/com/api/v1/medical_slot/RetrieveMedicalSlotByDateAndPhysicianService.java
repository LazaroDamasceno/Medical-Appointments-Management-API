package com.api.v1.medical_slot;

import com.api.v1.facade.Facade;
import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalSlotByDateAndPhysicianService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;

    public ResponseEntity<MedicalSlot> retrieve(String mln, DateTimeDTO dateTimeDTO) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(new BigInteger(mln));
        if (physicianOptional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = physicianOptional.get();
        LocalDateTime dateTime = Facade.convertStringToDateTime(dateTimeDTO.dateTime());
        return medicalSlotRepository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician) && e.getAvailableDateTime().equals(dateTime))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}
