package com.api.v4.medical_slot;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v4.auxiliaries.BetweenDatesDTO;

import java.util.List;

import jakarta.validation.constraints.Pattern;

@RestController
@AllArgsConstructor
@RequestMapping("api/v4/medical-slots")
public class RetrieveAllMedicalSlotsBetweenDatesController {

    private final RetrieveAllMedicalSlotsBetweenDatesService service;

    @GetMapping("between-dates/{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrieveAll(mln, dto);
    }
    
}
