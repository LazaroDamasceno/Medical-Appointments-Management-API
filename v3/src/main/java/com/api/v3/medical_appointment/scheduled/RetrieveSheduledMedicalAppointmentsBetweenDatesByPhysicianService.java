package com.api.v3.medical_appointment.scheduled;

import java.util.List;

import com.api.v3.medical_appointment.MedicalAppointment;
import com.api.v3.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.Pattern;

import com.api.v3.physician.Physician;
import com.api.v3.physician.RetrievePhysicianService;
import com.api.v3.auxiliaries.BetweenDatesDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveSheduledMedicalAppointmentsBetweenDatesByPhysicianService {
    
    private final RetrievePhysicianService retrievePhysician
;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(@Pattern(regexp = "[0-9]{7}") String mln, BetweenDatesDTO dto) {
        Physician physician = retrievePhysician.retrieve(mln);
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician)
                    && e.getAvailableDateTime().isAfter(dto.getFirstDate())
                    && e.getAvailableDateTime().isBefore(dto.getLastDate())
                    && e.getCancellationDate() == null
                ).toList()
        );
    }
    
}

