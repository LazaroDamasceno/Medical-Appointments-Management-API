package com.api.v1.medical_appointment;

import jakarta.validation.constraints.NotBlank;

public record MedicalNotesDTO(
    @NotBlank
    String notes
) {
    
}
