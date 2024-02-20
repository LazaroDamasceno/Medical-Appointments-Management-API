package com.api.v1.physician.retrieve_by_mln;

import com.api.v1.physician.Physician;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/physician")
@AllArgsConstructor
public class RetrievePhysicianController {

    private final RetrievePhysicianService service;

    @GetMapping("{mln}")
    public ResponseEntity<Physician> retrieve(@PathVariable String mln) {
        return service.retrieve(mln);
    }
}
