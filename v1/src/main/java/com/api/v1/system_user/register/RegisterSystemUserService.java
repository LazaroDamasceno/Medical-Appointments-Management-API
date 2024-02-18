package com.api.v1.system_user.register;

import com.api.v1.generics.Register;
import com.api.v1.system_user.CreateInstanceOfSystemUser;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterSystemUserService implements Register<ResponseEntity<Void>, RegisterSystemUserDTO> {

    private final SystemUserRepository repository;

    @Override
    public ResponseEntity<Void> register(RegisterSystemUserDTO parameter) {
        SystemUser systemUser = CreateInstanceOfSystemUser.create(parameter);
        repository.save(systemUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
