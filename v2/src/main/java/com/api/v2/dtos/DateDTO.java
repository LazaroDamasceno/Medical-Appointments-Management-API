package com.api.v2.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public record DateDTO(@NotBlank String date) {

       public LocalDate get() {
      return LocalDate.parse(date, GetDateTimeFormatter.getForDate());
   }
    
}
