package com.api.v1.medical_slot.retrieve_all_between_dates;

import com.api.v1.date_time_dto.BetweenDatesDTO;
import com.api.v1.generic_interfaces.retrieve_all.RetrieveAllWithTwoParameters;
import com.api.v1.medical_slot.MedicalSlot;
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
public class RetrieveAllMedicalSlotBetweenDatesController implements RetrieveAllWithTwoParameters<MedicalSlot, String, BetweenDatesDTO> {

    private final RetrieveAllMedicalSlotBetweenDatesService service;

    @Override
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln,
                                                         @RequestBody BetweenDatesDTO dto) {
        return service.retrieveAll(mln, dto);
    }
}
