package com.api.v1.medical_schedule;

import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.RetrieveMedicalSlotByDateAndPhysicianService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InsertMedicalSlotInMedicalScheduleService {

    private final MedicalScheduleRepository repository;
    private final PhysicianRepository physicianRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;

    public void register(String mln, DateTimeDTO dto) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(new BigInteger(mln));
        if (physicianOptional.isPresent()) {
            Physician physician = physicianOptional.get();
            ResponseEntity<MedicalSlot> medicalSlotResponseEntity = retrieveMedicalSlotByDateAndPhysician.retrieve(mln, dto);
            MedicalSlot medicalSlot = medicalSlotResponseEntity.getBody();
            Optional<MedicalSchedule> medicalScheduleOptional = repository.findByPhysician(physician);
            if (medicalScheduleOptional.isPresent()) {
                MedicalSchedule medicalSchedule = medicalScheduleOptional.get();
                medicalSchedule.getMedicalSlots().add(medicalSlot);
                repository.save(medicalSchedule);
            }
        }
    }
}
