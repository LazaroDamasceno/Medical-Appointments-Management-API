package com.api.v1.medical_appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.BetweenDatesDTO;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalAppointmentsBetweenDatesByPhysicianService {

    private final MedicalAppointmentRepository repository;
    private final PhysicianRepository physicianRepository;

    ResponseEntity<List<MedicalAppointment>> retrive(String mln, BetweenDatesDTO dto) {
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        List<MedicalAppointment> medicalAppointments = repository
            .findAll()
            .stream()
            .filter(e -> e.getPhysician().equals(physician.get())
                && e.getAvailableDateTime().isAfter(dto.firstDate())
                && e.getAvailableDateTime().isBefore(dto.lastDate())
            ).toList();
        return ResponseEntity.ok(medicalAppointments);
    }
    
}
