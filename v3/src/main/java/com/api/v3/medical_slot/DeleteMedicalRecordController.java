package com.api.v3.medical_slot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v3.dtos.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class DeleteMedicalRecordController {

    private final DeleteMedicalRecordService service;

    public ResponseEntity<Void> delete(@PathVariable String mln, @RequestBody DateTimeDTO dto) {
        return service.delete(mln, dto);
    }
    
}
