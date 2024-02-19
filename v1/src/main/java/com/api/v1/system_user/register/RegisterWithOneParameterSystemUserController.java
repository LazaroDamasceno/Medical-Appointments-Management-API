package com.api.v1.system_user.register;

import com.api.v1.generics.RegisterWithOneParameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/system-user")
@AllArgsConstructor
public class RegisterWithOneParameterSystemUserController implements RegisterWithOneParameter<RegisterSystemUserDTO> {

    private final RegisterWithOneParameterSystemUserService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterSystemUserDTO parameter) {
        return service.register(parameter);
    }
}
