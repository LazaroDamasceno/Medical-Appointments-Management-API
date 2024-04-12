package com.api.v1.medical_appointment.add_medical_notes;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

public record MedicalNotesDTO(
    @NotNull
    @Size(min=9, max=9)
    String ssn,

    @NotNull
    @Size(min=7, max=7)
    String mln,

    @NotNull
    LocalDateTime dateTime,

    @NotBlank
    String notes
) {
} 