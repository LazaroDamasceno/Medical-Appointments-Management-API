package com.api.v2.medical_record;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.patient.Patient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddMedicalAppointmentToMedicalRecordService {

    private final MedicalRecordRepository repository;

    public void add(Patient patient, MedicalAppointment medicalAppointment) {
        MedicalRecord medicalRecord = null;
        Optional<MedicalRecord> medicalRecordOptional = repository.findByPatient(patient);
        if (medicalRecordOptional.isEmpty()) {
            medicalRecord = new MedicalRecord(medicalAppointment.getPhysician(), patient);
            medicalRecord.getMedicalAppointments().add(medicalAppointment);
        } else {
            medicalRecord = medicalRecordOptional.get();
            medicalRecord.getMedicalAppointments().add(medicalAppointment);
        }
        repository.save(medicalRecord);
    }
    
}
