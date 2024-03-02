package com.api.v3.medical_appointment.scheduled;

import java.util.List;

import com.api.v3.medical_appointment.MedicalAppointment;
import com.api.v3.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;

import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Pattern;

@Service
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsByPhysicianService {

    private final RetrievePhysicianService retrievePhysician;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(@Pattern(regexp = "[//d]{7}") String mln) {
        Physician physician = retrievePhysician.retrieve(mln);
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician)
                                && e.getCancellationDate() == null
                        )
                        .toList()
        );
    }
    
}
