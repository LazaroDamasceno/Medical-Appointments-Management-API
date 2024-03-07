package com.api.v4.physician;

import com.api.v4.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

record RegisterPhysicianDTO(
        @NotBlank
        @Pattern(regexp = "[0-9]{7}") String mln,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
