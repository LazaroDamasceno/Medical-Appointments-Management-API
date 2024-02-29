package com.api.v3.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.NotBlank;

public record DateTimeDTO(@NotBlank String dateTime) {

   public LocalDateTime get() {
      return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
   }
        
}
