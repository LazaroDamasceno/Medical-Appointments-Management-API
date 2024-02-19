package com.api.v1.medical_schedule.retrieve_all;

import com.api.v1.generic_interfaces.RetrieveAllWithoutParameters;
import com.api.v1.medical_schedule.MedicalSchedule;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/medical-schedules")
@AllArgsConstructor
public class RetrieveAllWithoutParametersMedicalSchedulesController implements RetrieveAllWithoutParameters<MedicalSchedule> {

    private final RetrieveAllWithoutParametersMedicalSchedulesService service;

    @Override
    @GetMapping
    public ResponseEntity<List<MedicalSchedule>> retriveAll() {
        return service.retriveAll();
    }
}
