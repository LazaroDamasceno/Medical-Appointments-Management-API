package com.api.v1.medical_appointment.scheduled;

import java.util.List;
import java.util.Optional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveScheduledMedicalAppointmentsByPhysicianService {

    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String mln) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        return physician.map(value -> ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(value)
                                && e.getCancellationDate() == null
                        )
                        .toList()
        )).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
}
