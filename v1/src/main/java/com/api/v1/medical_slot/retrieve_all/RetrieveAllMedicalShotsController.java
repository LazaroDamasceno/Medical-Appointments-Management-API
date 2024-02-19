package com.api.v1.medical_slot.retrieve_all;

import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.generic_interfaces.RetrieveAllWithTwoParameters;
import com.api.v1.medical_slot.MedicalSlot;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/medical-slots")
public class RetrieveAllMedicalShotsController implements RetrieveAllWithTwoParameters<MedicalSlot, String, DateTimeDTO> {

    private final RetrieveAllMedicalShotsService service;

    @Override
    @GetMapping("{mln}")
    public ResponseEntity<List<MedicalSlot>> retrieveAll(@PathVariable String mln, @RequestBody DateTimeDTO dateTimeDTO) {
        return service.retrieveAll(mln, dateTimeDTO);
    }
}
