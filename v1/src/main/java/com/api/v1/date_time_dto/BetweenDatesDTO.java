package com.api.v1.date_time_dto;

import jakarta.validation.constraints.NotBlank;

public record BetweenDatesDTO(
        @NotBlank
        String firstDateTime,
        @NotBlank
        String lastDateTime
) {
}
