package com.api.v1.physician;

public interface CreateInstanceOfPhysician {

    static Physician create(RegisterPhysicianDTO dto) {
        return new Physician(dto);
    }

}
