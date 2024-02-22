package com.api.v1.auxiliary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ConvertToDate {

    static LocalDate convert(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dtf);
    }
    
}
