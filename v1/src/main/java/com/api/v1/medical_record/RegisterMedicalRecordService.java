package com.api.v1.medical_record;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalRecordService {

    private final MedicalRecordRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrievePatientBySsnService retrievePatientBySsn;

    public ResponseEntity<Void> register(String mln, String ssn) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        if (physician.isEmpty() || patient.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalRecord medicalRecord = new MedicalRecord(physician.get(), patient.get());
        repository.save(medicalRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
