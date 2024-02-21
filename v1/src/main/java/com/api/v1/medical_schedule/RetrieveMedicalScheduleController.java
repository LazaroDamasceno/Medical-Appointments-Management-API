package com.api.v1.medical_schedule;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medical-schedule")
@AllArgsConstructor
public class RetrieveMedicalScheduleController {

    private final RetrieveMedicalScheduleService service;

    @GetMapping("{mln}")
    public ResponseEntity<MedicalSchedule> retrieve(@PathVariable String mln) {
        return service.retrieve(mln);
    }
}
