package com.api.v3.system_user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterSystemUserDTO(
        @NotBlank
        String fullName,
        @NotBlank
        @Pattern(regexp = "[0-9]{9}") String ssn,
        @NotBlank
        @Pattern(regexp = "[1-3][0-9]/[0-9][0-2]/20[0-9][0-9]")
        String birthDay,
        @NotBlank
        String email,
        @NotBlank
        String phoneNumber
) {
}
