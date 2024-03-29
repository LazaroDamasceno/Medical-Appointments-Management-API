package com.api.v1.medical_appointment.add_notes;

import com.api.v1.auxiliary.DateTimeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalNotesDTO(@NotNull DateTimeDTO dateTimeDTO, @NotBlank String notes) {

}
