package com.api.v1.physician.terminate;

import com.api.v1.generic_interfaces.terminate.Terminate;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/physician")
@AllArgsConstructor
public class TerminatePhysicianController implements Terminate {

    private final TerminatePhysicianService service;

    @Override
    @PatchMapping("{registrationNumber}")
    public ResponseEntity<Void> terminate(@PathVariable String registrationNumber) {
        return service.terminate(registrationNumber);
    }
}
