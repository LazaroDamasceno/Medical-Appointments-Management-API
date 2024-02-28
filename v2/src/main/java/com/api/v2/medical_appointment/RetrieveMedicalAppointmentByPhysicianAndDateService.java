package com.api.v2.medical_appointment;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalAppointmentByPhysicianAndDateService {

    private final MedicalAppointmentRepository repository;
    private final PhysicianRepository physicianRepository;

    public Optional<MedicalAppointment> retrieve(String mln, DateTimeDTO dto) {
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        return physician.flatMap(value -> repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(dto.get())
                        && e.getPhysician().equals(value)
                ).findAny());
    }
    
}
