package com.api.v2.physician;

import com.api.v2.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPhysicianDTO(
        @NotBlank
        String mln,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
