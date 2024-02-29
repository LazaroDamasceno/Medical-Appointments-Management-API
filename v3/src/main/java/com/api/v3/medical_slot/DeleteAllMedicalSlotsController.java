package com.api.v3.medical_slot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-slots")
@AllArgsConstructor
public class DeleteAllMedicalSlotsController {

    private final DeleteAllMedicalSlotsService service;

    @DeleteMapping("{mln}")
    public ResponseEntity<Void> delete(@PathVariable String mln) {
        return service.delete(mln);
    }
    
}
