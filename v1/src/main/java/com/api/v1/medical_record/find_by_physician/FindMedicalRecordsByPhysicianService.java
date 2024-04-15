package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import com.api.v1.medical_record.MedicalRecord;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindMedicalRecordsByPhysicianService {

    List<MedicalRecord> findByPhysicianLicenseNumber(@NotNull @Size(min=7, max=7) String physicianLicenseNumber);
    
}
