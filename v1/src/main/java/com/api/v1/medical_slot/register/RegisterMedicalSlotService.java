package com.api.v1.medical_slot.register;

import com.api.v1.generic_interfaces.RegisterWithTwoParameters;
import com.api.v1.medical_slot.CreateInstanceOfMedicalSlot;
import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.MedicalSlotRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegisterMedicalSlotService implements RegisterWithTwoParameters<String, DateTimeDTO> {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;

    @Override
    public ResponseEntity<Void> register(String mln, DateTimeDTO dateTimeDTO) {
        Optional<Physician> physician = physicianRepository.findByMln(new BigInteger(mln));
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalSlot medicalSlot = CreateInstanceOfMedicalSlot.create(physician.get(), dateTimeDTO);
        medicalSlotRepository.save(medicalSlot);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
