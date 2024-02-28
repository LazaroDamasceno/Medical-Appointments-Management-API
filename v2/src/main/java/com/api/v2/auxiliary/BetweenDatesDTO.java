package com.api.v2.auxiliary;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record BetweenDatesDTO(@NotBlank String firstDate, @NotBlank String lastDate) {
   
   public LocalDateTime getFirstDate() {
      return LocalDateTime.parse(firstDate, GetDateTimeFormatter.getForDateTime());
   }

   public LocalDateTime getLastDate() {
      return LocalDateTime.parse(firstDate, GetDateTimeFormatter.getForDateTime());
   }

}
