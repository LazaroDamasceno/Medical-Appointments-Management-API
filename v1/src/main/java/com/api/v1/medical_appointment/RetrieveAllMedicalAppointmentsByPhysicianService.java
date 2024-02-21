package com.api.v1.medical_appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalAppointmentsByPhysicianService {

    private final MedicalAppointmentRepository repository;
    private final PhysicianRepository physicianRepository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String mln) {
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician.get()))
                .toList()
        );
    }
    
}
