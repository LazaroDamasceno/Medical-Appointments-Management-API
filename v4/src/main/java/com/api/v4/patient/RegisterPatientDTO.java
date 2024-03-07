package com.api.v4.patient;

import com.api.v4.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

record RegisterPatientDTO(
        @NotBlank
        String fullAddress,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
