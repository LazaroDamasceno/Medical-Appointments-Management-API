package com.api.v1.medical_slot;

import jakarta.validation.constraints.NotBlank;

public record AvaliableDateTimeDTO(
        @NotBlank
        String availableDateTime
) {
}
