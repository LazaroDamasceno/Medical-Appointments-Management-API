package com.api.v3.physician;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v3/physicians")
@AllArgsConstructor
public class RetrieveAllPhysiciansController {

    private final RetrieveAllPhysiciansService service;

    @GetMapping
    public ResponseEntity<List<Physician>> retriveAll() {
        return service.retriveAll();
    }
}
