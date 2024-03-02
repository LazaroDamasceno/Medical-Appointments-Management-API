package com.api.v3.medical_appointment.add_notes;

import com.api.v3.auxiliaries.DateTimeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalNotesDTO(@NotNull DateTimeDTO dateTimeDTO, @NotBlank String notes) {

}
