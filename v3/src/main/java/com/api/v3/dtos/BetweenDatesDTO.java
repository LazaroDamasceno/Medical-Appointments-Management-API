package com.api.v3.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.NotBlank;

public record BetweenDatesDTO(@NotBlank String firstDate, @NotBlank String lastDate) {
   
   public LocalDateTime getFirstDate() {
      return LocalDateTime.parse(firstDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
   }

   public LocalDateTime getLastDate() {
      return LocalDateTime.parse(firstDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
   }

}
