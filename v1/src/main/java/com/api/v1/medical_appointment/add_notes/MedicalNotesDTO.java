package com.api.v1.medical_appointment.add_notes;

import jakarta.validation.constraints.NotBlank;

public record MedicalNotesDTO(@NotBlank String dateTime, @NotBlank String notes) {

}
