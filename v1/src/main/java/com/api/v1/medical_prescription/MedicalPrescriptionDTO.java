package com.api.v1.medical_prescription;

import com.api.v1.auxiliary.DateTimeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalPrescriptionDTO(@NotNull DateTimeDTO dateTimeDTO, @NotBlank String prescription) {
    
}
