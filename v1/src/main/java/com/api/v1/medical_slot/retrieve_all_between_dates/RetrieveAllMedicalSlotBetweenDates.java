package com.api.v1.medical_slot.retrieve_all_between_dates;

import com.api.v1.medical_schedule.MedicalScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalSlotBetweenDates  {

    private  final MedicalScheduleRepository repository;

}
