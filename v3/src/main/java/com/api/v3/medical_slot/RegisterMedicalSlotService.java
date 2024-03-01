package com.api.v3.medical_slot;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;
import com.api.v3.auxiliaries.dtos.DateTimeDTO;
import com.api.v3.auxiliaries.exceptions.MedicalSlotAlreadyExistException;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterMedicalSlotService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final RetrievePhysicianService retrievePhysician;

    public ResponseEntity<Void> register(String mln, DateTimeDTO dateTimeDTO) {
        Physician physician = retrievePhysician.retrieve(mln);
        Optional<MedicalSlot> medicalSlotOptional = medicalSlotRepository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician)
                    && e.getAvailableDateTime().equals(dateTimeDTO.get())
                ).findAny();
        if (medicalSlotOptional.isPresent()) throw new MedicalSlotAlreadyExistException();
        MedicalSlot medicalSlot = new MedicalSlot(physician, dateTimeDTO);
        medicalSlotRepository.save(medicalSlot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
