package com.api.v3.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/physician")
@AllArgsConstructor
public class TerminatePhysicianController {

    private final TerminatePhysicianService service;

    @PatchMapping("{mln}")
    public ResponseEntity<Void> terminate(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln) {
        return service.terminate(mln);
    }
}
