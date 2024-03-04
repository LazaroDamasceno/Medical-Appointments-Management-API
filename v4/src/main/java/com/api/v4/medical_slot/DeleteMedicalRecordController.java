package com.api.v4.medical_slot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.v4.auxiliaries.DateTimeDTO;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class DeleteMedicalRecordController {

    private final DeleteMedicalRecordService service;

    @DeleteMapping("{mln}")
    public ResponseEntity<Void> delete(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, @RequestBody DateTimeDTO dto) {
        return service.delete(mln, dto);
    }
    
}
