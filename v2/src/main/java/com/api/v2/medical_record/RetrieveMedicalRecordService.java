package com.api.v2.medical_record;

import java.util.Optional;

import com.api.v2.exceptions.DeniedAccessException;
import com.api.v2.exceptions.MedicalSlotNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.patient.Patient;
import com.api.v2.patient.RetrievePatientService;
import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalRecordService {

    private final MedicalRecordRepository repository;
    private final RetrievePhysicianService retrievePhysician;
    private final RetrievePatientService retrievePatientBySsn;

    public final ResponseEntity<MedicalRecord> retrieve(String mln, String ssn) {
        Physician physician = retrievePhysician.retrieve(mln);
        Patient patient = retrievePatientBySsn.retrieve(ssn);
        Optional<MedicalRecord> medicalRecord = repository.findByPatient(patient);
        if (medicalRecord.isEmpty()) throw new MedicalSlotNotFoundException();
        if (!medicalRecord.get().getPhysician().equals(physician)) throw new DeniedAccessException();
        return ResponseEntity.ok(medicalRecord.get());
    }
    
}