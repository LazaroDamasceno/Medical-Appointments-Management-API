package com.api.v4.medical_appointment.add_notes;

import com.api.v4.auxiliaries.DateTimeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

record MedicalNotesDTO(@NotNull DateTimeDTO dateTimeDTO, @NotBlank String notes) {

}
