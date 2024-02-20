package com.api.v1.medical_slot.register;

import com.api.v1.medical_schedule.insert_medical_slot_in_medical_schedule.InsertMedicalSlotInMedicalScheduleService;
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
public class RegisterMedicalSlotService {

    private final MedicalSlotRepository medicalSlotRepository;
    private final PhysicianRepository physicianRepository;
    private final InsertMedicalSlotInMedicalScheduleService insertMedicalSlotInMedicalSchedule;

    public ResponseEntity<Void> register(String mln, DateTimeDTO dateTimeDTO) {
        Optional<Physician> physician = physicianRepository.findByMln(new BigInteger(mln));
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalSlot medicalSlot = CreateInstanceOfMedicalSlot.create(physician.get(), dateTimeDTO);
        medicalSlotRepository.save(medicalSlot);
        insertMedicalSlotInMedicalSchedule.register(mln, dateTimeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
