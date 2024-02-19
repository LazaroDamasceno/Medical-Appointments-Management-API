package com.api.v1.medical_schedule.retrieve_all;

import com.api.v1.generics.RetrieveAll;
import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.medical_schedule.MedicalScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSchedulesService implements RetrieveAll<MedicalSchedule> {

    private final MedicalScheduleRepository repository;

    @Override
    public ResponseEntity<List<MedicalSchedule>> retriveAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
