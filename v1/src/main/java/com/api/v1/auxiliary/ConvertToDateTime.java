package com.api.v1.auxiliary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ConvertToDateTime {

    static LocalDateTime convertStringToDateTime(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, dtf);
    }

}
