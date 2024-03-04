package com.api.v4.medical_appointment.cancelled;

import java.util.List;

import com.api.v4.medical_appointment.MedicalAppointment;
import com.api.v4.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.physician.Physician;
import com.api.v4.physician.RetrievePhysicianService;

import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveCancelledMedicalAppointmentsByPhysicianService {

    private final RetrievePhysicianService retrievePhysician
;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(@Pattern(regexp = "[0-9]{7}") String mln) {
        Physician physician = retrievePhysician.retrieve(mln);
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician)
                                && e.getCancellationDate() != null
                        )
                        .toList()
        );
    }
    
}
