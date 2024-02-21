package com.api.v1.medical_slot;

import com.api.v1.medical_schedule.InsertMedicalSlotInMedicalScheduleService;
import com.api.v1.date_time_dto.DateTimeDTO;
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
    private final InsertMedicalSlotInMedicalScheduleService insertMedicalSlotInMedicalSchedule;

    public ResponseEntity<Void> register(String mln, DateTimeDTO dateTimeDTO) {
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalSlot medicalSlot = new MedicalSlot(physician.get(), dateTimeDTO);
        medicalSlotRepository.save(medicalSlot);
        insertMedicalSlotInMedicalSchedule.register(mln, dateTimeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
