package com.api.v1.medical_slot;

import com.api.v1.physician.Physician;

public interface CreateInstanceOfMedicalSlot {

    static MedicalSlot create(Physician physician, AvaliableDateTimeDTO dto) {
        return new MedicalSlot(physician, dto);
    }

}
