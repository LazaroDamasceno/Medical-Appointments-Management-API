package com.api.v1.auxiliary;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record BetweenDatesDTO(
        @NotBlank
        LocalDateTime firstDate,
        @NotBlank
        LocalDateTime lastDate
) {
}
