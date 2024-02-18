package com.api.v1.system_user.retrieve_all;

import com.api.v1.generics.RetrieveAll;
import com.api.v1.system_user.SystemUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/system-users")
@AllArgsConstructor
public class RetrieveAllSystemUsersController implements RetrieveAll<SystemUser> {

    private final RetrieveAllSystemUsersService service;

    @Override
    @GetMapping
    public ResponseEntity<List<SystemUser>> retriveAll() {
        return service.retriveAll();
    }

}
