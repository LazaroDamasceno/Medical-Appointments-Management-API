package com.api.v1.facade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Facade {

    static LocalDate convertStringToDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dtf);
    }

    static LocalDateTime convertStringToDateTime(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, dtf);
    }

}
