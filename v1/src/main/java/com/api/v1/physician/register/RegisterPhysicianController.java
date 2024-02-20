package com.api.v1.physician.register;

import com.api.v1.generic_interfaces.register.with_response_entity.RegisterWithOneParameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/physician")
@AllArgsConstructor
public class RegisterPhysicianController implements RegisterWithOneParameter<RegisterPhysicianDTO> {

    private final RegisterPhysicianService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterPhysicianDTO dto) {
        return service.register(dto);
    }

}
