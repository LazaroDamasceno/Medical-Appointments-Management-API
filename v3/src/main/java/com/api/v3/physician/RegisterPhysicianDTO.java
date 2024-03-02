package com.api.v3.physician;

import com.api.v3.system_user.RegisterSystemUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterPhysicianDTO(
        @NotBlank
        @Pattern(regexp = "[0-9]{7}") String mln,
        @NotNull
        RegisterSystemUserDTO systemUserDTO
) {
}
