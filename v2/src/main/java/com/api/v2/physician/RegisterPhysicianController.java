package com.api.v2.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/physician")
@AllArgsConstructor
public class RegisterPhysicianController {

    private final RegisterPhysicianService service;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody RegisterPhysicianDTO dto) {
        return service.register(dto);
    }

}
