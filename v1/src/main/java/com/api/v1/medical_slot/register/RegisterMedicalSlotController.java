package com.api.v1.medical_slot.register;

import com.api.v1.generic_interfaces.register.RegisterWithTwoParameters;
import com.api.v1.date_time_dto.DateTimeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medical-slot")
@AllArgsConstructor
public class RegisterMedicalSlotController implements RegisterWithTwoParameters<String, DateTimeDTO> {

    private final RegisterMedicalSlotService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> register(String mln, DateTimeDTO dateTimeDTO) {
        return service.register(mln, dateTimeDTO);
    }
}
