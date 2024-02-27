package com.api.v1.medical_prescription;

import jakarta.validation.constraints.NotBlank;

public record MedicalPrescriptionDTO(@NotBlank String dateTime, @NotBlank String prescription) {
    
}
