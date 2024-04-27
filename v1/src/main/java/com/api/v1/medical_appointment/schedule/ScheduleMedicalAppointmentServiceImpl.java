package com.api.v1.medical_appointment.schedule;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeConverter;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ScheduleMedicalAppointmentServiceImpl implements ScheduleMedicalAppointmentService {
    
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional
    public void schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(dto.physicianLicenseNumber());
        validateInput(patient, physician, dto.dateTime());
        MedicalAppointment medicalAppointment = new MedicalAppointment(dto.dateTime(), patient, physician);
        medicalAppointmentRepository.save(medicalAppointment);
        patient.addMedicalAppointment(medicalAppointment);
        patientRepository.save(patient);
        physician.addMedicalAppointment(medicalAppointment);
        physicianRepository.save(physician);
    }

    private void validateInput(Patient patient, Physician physician, String dateTime) {
        Optional<MedicalAppointment> medicalAppointment = medicalAppointmentRepository.findScheduledMedicalAppointmentByDate(patient, physician, DateTimeConverter.convertToDateTime(dateTime));
        boolean isMedicalAppointmentScheduled = medicalAppointment.isPresent() && medicalAppointment.get().getCancelationDateTime() == null;
        if (isMedicalAppointmentScheduled) throw new DuplicatedMedicalAppointmentException();
    }
    
}
