package com.api.v1.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/physician")
@AllArgsConstructor
public class RetrievePhysicianByMlnController {

    private final RetrievePhysicianByMlnService service;

    @GetMapping("{mln}")
    public ResponseEntity<Physician> retrieve(@PathVariable String mln) {
        return service.retrieve(mln);
    }
}
