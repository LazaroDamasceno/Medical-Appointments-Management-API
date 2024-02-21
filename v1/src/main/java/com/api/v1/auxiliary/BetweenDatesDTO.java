package com.api.v1.auxiliary;

import jakarta.validation.constraints.NotBlank;

public record BetweenDatesDTO(
        @NotBlank
        String firstDateTime,
        @NotBlank
        String lastDateTime
) {
}
