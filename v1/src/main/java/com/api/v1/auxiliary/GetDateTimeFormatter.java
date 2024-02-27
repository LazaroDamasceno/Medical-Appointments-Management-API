package com.api.v1.auxiliary;

import java.time.format.DateTimeFormatter;

public interface GetDateTimeFormatter {

    static DateTimeFormatter getForDate() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    static DateTimeFormatter getForDateTime() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
    
}
