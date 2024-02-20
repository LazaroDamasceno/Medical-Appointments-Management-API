package com.api.v1.system_user;

public interface CreateInstanceOfSystemUser {

    static SystemUser create(RegisterSystemUserDTO dto) {
        return new SystemUser(dto);
    }

}
