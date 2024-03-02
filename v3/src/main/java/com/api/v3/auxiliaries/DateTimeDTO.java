package com.api.v3.auxiliaries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DateTimeDTO(@Pattern(regexp = "[1-3][0-9]/[0-9][0-2]/20[0-9][0-9]/s[0-2][0-4]:[0-5][0-9]:[0-5][0-9]")
                          @NotBlank
                          String dateTime
) {

   public LocalDateTime get() {
      return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
   }
        
}
