package com.api.v1.medical_slot;

import com.api.v1.date_time_dto.BetweenDatesDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/medical-slots")
public class RetrieveAllMedicalSlotBetweenDatesController {

    private final RetrieveAllMedicalSlotBetweenDatesService service;

    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln, @RequestBody BetweenDatesDTO dto) {
        return service.retrieveAll(mln, dto);
    }
}
