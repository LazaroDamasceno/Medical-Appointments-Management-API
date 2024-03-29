package com.api.v2.patient;

import com.api.v2.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPatientDTO(
        @NotBlank
        String fullAddress,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
