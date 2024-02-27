package com.api.v1.medical_appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveFinishedMedicalAppointmentsByPhysicianService {

    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String mln) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician.get())
                )
                .toList());
    }
}
