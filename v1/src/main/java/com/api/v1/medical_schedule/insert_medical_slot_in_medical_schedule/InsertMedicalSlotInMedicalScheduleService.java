package com.api.v1.medical_schedule.insert_medical_slot_in_medical_schedule;

import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.facade.Facade;
import com.api.v1.generic_interfaces.register.with_void.RegisterWithTwoParametersUsingVoid;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.retrieve_by_date_and_physician.RetrieveMedicalSlotByDateAndPhysicianService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InsertMedicalSlotInMedicalScheduleService implements RegisterWithTwoParametersUsingVoid<String, DateTimeDTO> {

    private final MedicalScheduleRepository repository;
    private final PhysicianRepository physicianRepository;
    private final RetrieveMedicalSlotByDateAndPhysicianService retrieveMedicalSlotByDateAndPhysician;

    @Override
    public void register(String mln, DateTimeDTO dto) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(Facade.turnToBigInteger(mln));
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
