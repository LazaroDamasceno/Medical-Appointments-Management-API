package com.api.v1.convert_to_date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ConvertToDate {

    static LocalDate convertStringToDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dtf);
    }
    
}
