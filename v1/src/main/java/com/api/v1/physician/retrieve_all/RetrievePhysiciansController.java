package com.api.v1.physician.retrieve_all;

import com.api.v1.generic_interfaces.retrieve_all.RetrieveAllWithoutParameters;
import com.api.v1.physician.Physician;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/physicians")
@AllArgsConstructor
public class RetrievePhysiciansController implements RetrieveAllWithoutParameters<Physician> {

    private final RetrievePhysiciansService service;

    @Override
    @GetMapping
    public ResponseEntity<List<Physician>> retriveAll() {
        return service.retriveAll();
    }
}
