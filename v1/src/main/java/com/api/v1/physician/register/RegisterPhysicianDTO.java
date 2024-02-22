package com.api.v1.physician.register;

import com.api.v1.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPhysicianDTO(
        @NotBlank
        String mln,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
