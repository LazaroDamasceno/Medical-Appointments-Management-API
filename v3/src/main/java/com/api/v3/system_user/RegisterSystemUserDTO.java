package com.api.v3.system_user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterSystemUserDTO(
        @NotBlank
        String fullName,
        @NotBlank
        @Pattern(regexp = "[//d]{9}") String ssn,
        @NotBlank
        @Pattern(regexp = "[1-3][//d][//d][0-2]/20[//d][//d]")
        String birthDay,
        @NotBlank
        String email,
        @NotBlank
        String phoneNumber
) {
}
