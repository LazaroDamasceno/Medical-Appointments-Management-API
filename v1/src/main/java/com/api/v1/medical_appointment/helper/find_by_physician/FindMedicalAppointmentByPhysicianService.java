package com.api.v1.medical_appointment.helper.find_by_physician;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.MedicalAppointmentNotFoundException;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByPhysicianService implements FindMedicalAppointmentByPhysician {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional(readOnly = true)
    public MedicalAppointment findByPhysician(@PhysicianLicenseNumber String physicianLicenseNumber, @NotNull ZonedDateTime dateTime) {
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        Optional<MedicalAppointment> medicalAppointment = repository.findScheduledMedicalAppointmentByPhysician(physician, dateTime);
        validateInput(medicalAppointment);
        return medicalAppointment.get();
    }

    private void validateInput(Optional<MedicalAppointment> optional) {
        if (optional.isEmpty()) throw new MedicalAppointmentNotFoundException();
    }
    
}
