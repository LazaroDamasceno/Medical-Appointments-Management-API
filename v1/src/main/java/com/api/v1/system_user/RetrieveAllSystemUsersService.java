package com.api.v1.system_user;

import com.api.v1.generics.RetrieveAll;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllSystemUsersService implements RetrieveAll<SystemUser> {

    private final SystemUserRepository repository;

    @Override
    public ResponseEntity<List<SystemUser>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
