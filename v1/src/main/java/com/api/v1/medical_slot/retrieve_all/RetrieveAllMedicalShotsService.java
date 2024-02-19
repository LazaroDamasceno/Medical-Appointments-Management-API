package com.api.v1.medical_slot.retrieve_all;

import com.api.v1.facade.Facade;
import com.api.v1.generic_interfaces.RetrieveAllWithTwoParameters;
import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.MedicalSlotRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalShotsService implements RetrieveAllWithTwoParameters<MedicalSlot, String, DateTimeDTO> {

    private final MedicalSlotRepository repository;
    private final PhysicianRepository physicianRepository;

    @Override
    public ResponseEntity<List<MedicalSlot>> retrieveAll(String mln, DateTimeDTO dateTimeDTO) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(new BigInteger(mln));
        if (physicianOptional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = physicianOptional.get();
        LocalDateTime dateTime = Facade.convertStringToDateTime(dateTimeDTO.dateTime());
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician) && e.getAvailableDateTime().equals(dateTime))
                        .toList()
        );
    }
}
