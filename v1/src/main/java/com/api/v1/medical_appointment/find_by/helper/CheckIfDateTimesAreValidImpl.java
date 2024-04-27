package com.api.v1.medical_appointment.find_by.helper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.DateTimeConverter;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;
import com.api.v1.medical_appointment.find_by.exception.DateTimesEqualityException;
import com.api.v1.medical_appointment.find_by.exception.FutureFirstDateTimeException;
import com.api.v1.medical_appointment.find_by.exception.PastLastDateTimeException;

@Service
public class CheckIfDateTimesAreValidImpl implements CheckIfDateTimesAreValid {

    @Override
    @Transactional(readOnly = true)
    public void checkEquality(BetweenDatesTimesDTO dto) {
        if (getFirstDateTime(dto).isEqual(getLastDateTime(dto))) {
            throw new DateTimesEqualityException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void checkIfFirstDateTimeIsBeyondLastDateTime(BetweenDatesTimesDTO dto) {
        if (getFirstDateTime(dto).isAfter(getLastDateTime(dto))) {
            throw new FutureFirstDateTimeException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void checkIfLastDateTimeIsBeyondFirstDateTime(BetweenDatesTimesDTO dto) {
        if (getLastDateTime(dto).isAfter(getFirstDateTime(dto))) {
            throw new PastLastDateTimeException();
        }
    }

    private LocalDateTime getFirstDateTime(BetweenDatesTimesDTO dto) {
        return DateTimeConverter.convertToDateTime(dto.firstDateTime());
    }

    private LocalDateTime getLastDateTime(BetweenDatesTimesDTO dto) {
        return DateTimeConverter.convertToDateTime(dto.lastDateTime());
    }
    
}
