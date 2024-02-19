package com.api.v1.medical_schedule.retrieve_by_physician;

import com.api.v1.generics.RetrieveWithOneParameter;
import com.api.v1.medical_schedule.MedicalSchedule;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medical-schedule")
@AllArgsConstructor
public class RetrieveMedicalScheduleController implements RetrieveWithOneParameter<ResponseEntity<MedicalSchedule>, Long> {

    private final RetrieveMedicalScheduleService service;

    @Override
    @GetMapping("{mln}")
    public ResponseEntity<MedicalSchedule> retrieve(@PathVariable Long mln) {
        return service.retrieve(mln);
    }
}
