package com.api.v3.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record DateTimeDTO(@NotBlank String dateTime) {

   public LocalDateTime get() {
      return LocalDateTime.parse(dateTime, GetDateTimeFormatter.getForDateTime());
   }
        
}
