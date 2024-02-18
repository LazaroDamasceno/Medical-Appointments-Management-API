package com.api.v1.facade;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface Facade {

    static LocalDate convertStringToDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, dtf);
    }

    static BigInteger turnToBigInteger(String input) {
        return new BigInteger(input);
    }

}
