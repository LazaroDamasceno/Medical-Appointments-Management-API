package com.api.v4.auxiliaries;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DateDTO(
        @Pattern(regexp = "[1-3][0-9/[0-9][0-2]/20[0-9][0-9]")
        @NotBlank
        String date
) {

       public LocalDate get() {
      return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
   }
    
}
