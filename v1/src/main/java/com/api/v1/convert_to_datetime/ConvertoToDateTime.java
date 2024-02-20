package com.api.v1.convert_to_datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface ConvertoToDateTime {



    static LocalDateTime convertStringToDateTime(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, dtf);
    }

}
