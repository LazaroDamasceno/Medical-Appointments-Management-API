package com.api.v3.patient;

import com.api.v3.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPatientDTO(
        @NotBlank
        String fullAddress,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
