package com.api.v1.system_user;

import com.api.v1.system_user.register.RegisterSystemUserDTO;

public interface CreateInstanceOfSystemUser {

    static SystemUser create(RegisterSystemUserDTO dto) {
        return new SystemUser(dto);
    }

}
