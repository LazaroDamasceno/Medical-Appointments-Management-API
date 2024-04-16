package com.api.v1.medical_appointment.schedule;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.constants.HttpStatusCodes;

import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/new-medical-appointment")
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentControllerImpl implements ScheduleMedicalAppointmentController {

    private final ScheduleMedicalAppointmentService service;

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<Void> schedule(@NotNull @RequestBody ScheduleMedicalAppointmentDTO dto) {
        service.schedule(dto);
        return HttpStatusCodes.CREATED_201;
    }
    
}