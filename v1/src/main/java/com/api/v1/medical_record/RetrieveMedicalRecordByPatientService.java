package com.api.v1.medical_record;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalRecordByPatientService {

    private final MedicalRecordRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrievePatientBySsnService retrievePatientBySsn;

    public final ResponseEntity<MedicalRecord> retrieve(String mln, String ssn) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        if (physician.isEmpty() || patient.isEmpty()) return ResponseEntity.badRequest().build();
        Optional<MedicalRecord> medicalRecord = repository.findByPatient(patient.get());
        if (medicalRecord.isEmpty() || !medicalRecord.get().getPhysician().equals(physician.get())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(medicalRecord.get());
    }
    
}