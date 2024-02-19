package com.api.v1.physician;

import com.api.v1.physician.register.RegisterPhysicianDTO;

public interface CreateInstanceOfPhysician {

    static Physician create(RegisterPhysicianDTO dto) {
        return new Physician(dto);
    }

}
