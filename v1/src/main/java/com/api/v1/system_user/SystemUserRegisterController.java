package com.api.v1.system_user;

import com.api.v1.generics.Register;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/system-user")
@AllArgsConstructor
public class SystemUserRegisterController  implements Register<ResponseEntity<Void>, RegisterSystemUserDTO> {

    private final RegisterSystemUserService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterSystemUserDTO parameter) {
        return service.register(parameter);
    }
}
