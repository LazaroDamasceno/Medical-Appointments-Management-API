package com.api.v2.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v2.dtos.BetweenDatesDTO;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v2/medical-slots")
public class RetrieveAllMedicalSlotsBetweenDatesController {

    private final RetrieveAllMedicalSlotsBetweenDatesService service;

    @GetMapping("between-dates/{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrieveAll(mln, dto);
    }
    
}
