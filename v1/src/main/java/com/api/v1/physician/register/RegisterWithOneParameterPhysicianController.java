package com.api.v1.physician.register;

import com.api.v1.generic_interfaces.RegisterWithOneParameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/physician")
@AllArgsConstructor
public class RegisterWithOneParameterPhysicianController implements RegisterWithOneParameter<RegisterPhysicianDTO> {

    private final RegisterWithOneParameterPhysicianService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterPhysicianDTO dto) {
        return service.register(dto);
    }

}
