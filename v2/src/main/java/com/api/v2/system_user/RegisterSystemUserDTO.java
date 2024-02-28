package com.api.v2.system_user;

import jakarta.validation.constraints.NotBlank;

public record RegisterSystemUserDTO(
        @NotBlank
        String fullName,
        @NotBlank
        String ssn,
        @NotBlank
        String birthDay,
        @NotBlank
        String email,
        @NotBlank
        String phoneNumber
) {
}
