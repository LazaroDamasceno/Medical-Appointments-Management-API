package com.api.v3.auxiliaries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record BetweenDatesDTO(@Pattern(regexp = "[1-3][0-9]/[0-1][0-2]/20[0-9][0-9] [0-2][0-4]:[0-5][0-9]:[0-5][0-9]")
                              @NotBlank
                              String firstDate,
                              @Pattern(regexp = "[1-3][0-9]/[0-1][0-2]/20[0-9][0-9] [0-2][0-4]:[0-5][0-9]:[0-5][0-9]")
                              @NotBlank
                              String lastDate
) {
   
   public LocalDateTime getFirstDate() {
      return LocalDateTime.parse(firstDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
   }

   public LocalDateTime getLastDate() {
      return LocalDateTime.parse(firstDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
   }

}
