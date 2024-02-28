package com.api.v2.medical_appointment.add_notes;

import com.api.v2.auxiliary.DateTimeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalNotesDTO(@NotNull DateTimeDTO dateTimeDTO, @NotBlank String notes) {

}
