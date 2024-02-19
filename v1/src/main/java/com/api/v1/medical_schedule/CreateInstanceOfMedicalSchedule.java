package com.api.v1.medical_schedule;

import com.api.v1.physician.Physician;

public interface CreateInstanceOfMedicalSchedule {

    static MedicalSchedule create(Physician physician) {
        return new MedicalSchedule(physician);
    }

}
