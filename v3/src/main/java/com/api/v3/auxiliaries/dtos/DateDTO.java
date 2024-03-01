package com.api.v3.auxiliaries.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.validation.constraints.NotBlank;

public record DateDTO(@NotBlank String date) {

       public LocalDate get() {
      return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
   }
    
}
