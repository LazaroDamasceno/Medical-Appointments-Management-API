package com.api.v1.medical_schedule.register;

import com.api.v1.generic_interfaces.register.with_void.RegisterWithVoid;
import com.api.v1.medical_schedule.CreateInstanceOfMedicalSchedule;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import com.api.v1.physician.Physician;
Fixeimport com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterWithOneParameterMedicalScheduleService implements RegisterWithVoid<Physician> {

    private final MedicalScheduleRepository repository;
    private final PhysicianRepository physicianRepository;

    public void register(Physician physician) {
        MedicalSchedule medicalSchedule = CreateInstanceOfMedicalSchedule.create(physician);
        repository.save(medicalSchedule);
        physician.setMedicalSchedule(medicalSchedule);
        physicianRepository.save(physician);
    }
}
