package com.api.v1.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/medical-slots")
public class RetrieveAllMedicalSlotBetweenDatesController {

    private final RetrieveAllMedicalSlotBetweenDatesService service;

    @GetMapping("{mln}/{firstDate}/{lastDate}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln, 
                                                        @PathVariable LocalDateTime firstDate, 
                                                        @PathVariable LocalDateTime lastDate) {
        return service.retrieveAll(mln, firstDate, lastDate);
    }
}
