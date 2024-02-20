package com.api.v1.medical_slot.retrieve_by_date_and_physician;

import com.api.v1.generic_interfaces.retrieve.RetrieveWithTwoParameters;
import com.api.v1.date_time_dto.DateTimeDTO;
import com.api.v1.medical_slot.MedicalSlot;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class RetrieveMedicalSlotByDateAndPhysicianController implements RetrieveWithTwoParameters<MedicalSlot, String, DateTimeDTO> {

    private final RetrieveMedicalSlotByDateAndPhysicianService service;

    @Override
    @GetMapping("{mln}")
    public ResponseEntity<MedicalSlot> retrieve(@PathVariable String mln, @RequestBody DateTimeDTO dateTimeDTO) {
        return service.retrieve(mln, dateTimeDTO);
    }
}
