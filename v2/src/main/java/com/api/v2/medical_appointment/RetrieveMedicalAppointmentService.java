package com.api.v2.medical_appointment;

import com.api.v2.dtos.DateTimeDTO;
import com.api.v2.exceptions.MedicalAppointmentNotFound;
import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianService;
import org.springframework.stereotype.Service;

import com.api.v2.patient.Patient;
import com.api.v2.patient.RetrievePatientService;

import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientService retrievePatientBySsn;
    private final RetrievePhysicianService retrievePhysician;

    public MedicalAppointment retrieveByPatient(String ssn, DateTimeDTO dto) {
        Patient patient = retrievePatientBySsn.retrieve(ssn);
        Optional<MedicalAppointment> medicalAppointment = repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(dto.get())
                        && e.getPatient().equals(patient)
                ).findAny();
        if (medicalAppointment.isEmpty()) throw new MedicalAppointmentNotFound();
        return medicalAppointment.get();
    }

    public MedicalAppointment retrieveByPhysician(String mln, DateTimeDTO dto) {
        Physician physician = retrievePhysician
.retrieve(mln);
        Optional<MedicalAppointment> medicalAppointment = repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(dto.get())
                        && e.getPhysician().equals(physician)
                ).findAny();
        if (medicalAppointment.isEmpty()) throw new MedicalAppointmentNotFound();
        return medicalAppointment.get();
    }
    
}
