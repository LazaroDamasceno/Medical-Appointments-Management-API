package com.api.v1.medical_slot;

import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.physician.Physician;

public interface CreateInstanceOfMedicalSlot {

    static MedicalSlot create(Physician physician, DateTimeDTO dto) {
        return new MedicalSlot(physician, dto);
    }

}
