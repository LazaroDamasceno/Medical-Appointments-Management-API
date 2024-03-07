package com.api.v4.medical_appointment;

import com.api.v4.physician.Physician;
import com.api.v4.physician.RetrievePhysicianService;
import com.api.v4.auxiliaries.DateTimeDTO;
import com.api.v4.auxiliaries.MedicalAppointmentNotFoundException;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Service;

import com.api.v4.patient.Patient;
import com.api.v4.patient.RetrievePatientService;

import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
class RetrieveMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePatientService retrievePatientBySsn;
    private final RetrievePhysicianService retrievePhysician;

    public MedicalAppointment retrieveByPatient(@Pattern(regexp = "[0-9]{9}") String ssn, DateTimeDTO dto) {
        Patient patient = retrievePatientBySsn.retrieve(ssn);
        Optional<MedicalAppointment> medicalAppointment = repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(dto.get())
                        && e.getPatient().equals(patient)
                ).findAny();
        if (medicalAppointment.isEmpty()) throw new MedicalAppointmentNotFoundException();
        return medicalAppointment.get();
    }

    public MedicalAppointment retrieveByPhysician(@Pattern(regexp = "[0-9]{7}") String mln, DateTimeDTO dto) {
        Physician physician = retrievePhysician.retrieve(mln);
        Optional<MedicalAppointment> medicalAppointment = repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(dto.get())
                        && e.getPhysician().equals(physician)
                ).findAny();
        if (medicalAppointment.isEmpty()) throw new MedicalAppointmentNotFoundException();
        return medicalAppointment.get();
    }
    
}
