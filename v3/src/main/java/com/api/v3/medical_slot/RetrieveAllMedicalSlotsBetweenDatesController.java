package com.api.v3.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v3.auxiliaries.BetweenDatesDTO;

import jakarta.validation.constraints.Pattern;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v3/medical-slots")
public class RetrieveAllMedicalSlotsBetweenDatesController {

    private final RetrieveAllMedicalSlotsBetweenDatesService service;

    @GetMapping("between-dates/{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable @Pattern(regexp = "[//d]{7}") String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrieveAll(mln, dto);
    }
    
}
