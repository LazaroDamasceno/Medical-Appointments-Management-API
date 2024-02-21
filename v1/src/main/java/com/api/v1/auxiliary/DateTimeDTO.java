package com.api.v1.auxiliary;

import jakarta.validation.constraints.NotBlank;

public record DateTimeDTO(
        @NotBlank
        String dateTime
) {
}
