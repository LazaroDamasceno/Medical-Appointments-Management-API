package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_record.MedicalRecord;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-record-by-physician")
@RequiredArgsConstructor
class FindMedicalRecordsByPhysicianController {
    
    private final FindMedicalRecordsByPhysicianService service;

    @GetMapping("{physicianLicenseNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalRecord>> findByPhysicianLicenseNumber(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber) {
        return ResponseEntity.ok(service.findByPhysicianLicenseNumber(physicianLicenseNumber));
    }

}
