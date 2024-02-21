package com.api.v1.system_user;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record RegisterSystemUserDTO(
        @NotBlank
        String fullName,
        @NotBlank
        String ssn,
        @NotBlank
        LocalDate birthDay,
        @NotBlank
        String email,
        @NotBlank
        String phoneNumber
) {
}
