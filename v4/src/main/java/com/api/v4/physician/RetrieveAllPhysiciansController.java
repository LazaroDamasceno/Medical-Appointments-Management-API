package com.api.v4.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v4/physicians")
@AllArgsConstructor
class RetrieveAllPhysiciansController {

    private final RetrieveAllPhysiciansService service;

    @GetMapping
    public ResponseEntity<List<Physician>> retriveAll() {
        return service.retriveAll();
    }
}
