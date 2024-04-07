package com.api.v1.medical_appointment.find.find_by_date;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find.MedicalAppointmentNotFoundException;
import com.api.v1.patient.Patient;
import com.api.v1.patient.find_by_ssn.FindPatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByMlnService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByDateService implements FindMedicalAppointmentByDate {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsnService findPatientBySsn;
    private final FindPhysicianByMlnService findPhysicianByMln;

    @Override
    @Transactional
    public MedicalAppointment findByDate(
        @NotNull @Size(min = 9, max = 9) String ssn,
        @NotNull @Size(min = 7, max = 7) String mln, 
        @NotNull Date dateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        Physician physician = findPhysicianByMln.findByMln(mln);
        validateInput(patient, physician, dateTime);
        return repository.findMedicalAppointmentByDate(patient, physician, dateTime);
    }

    private void validateInput(Patient patient, Physician physician, Date date) {
        if (repository.findMedicalAppointmentByDate(patient, physician, date) == null) {
            throw new MedicalAppointmentNotFoundException(patient, physician, date);
        }
    }
    
}
