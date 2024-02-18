package com.api.v1.system_user.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterSystemUserDTO(
        @NotBlank
        String fullName,
        @NotBlank
        String ssn,
        @NotBlank
        String birthDay,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phoneNumber
) {
}
