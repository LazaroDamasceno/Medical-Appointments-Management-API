package com.api.v3.medical_record;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.patient.Patient;
import com.api.v3.patient.RetrievePatientService;
import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;
import com.api.v3.auxiliaries.exceptions.ForbiddenOperationException;
import com.api.v3.auxiliaries.exceptions.MedicalSlotNotFoundException;

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
        if (!medicalRecord.get().getPhysician().equals(physician)) throw new ForbiddenOperationException();
        return ResponseEntity.ok(medicalRecord.get());
    }
    
}