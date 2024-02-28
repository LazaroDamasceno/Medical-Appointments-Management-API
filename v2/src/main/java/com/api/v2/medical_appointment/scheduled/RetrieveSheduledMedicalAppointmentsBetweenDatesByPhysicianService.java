package com.api.v2.medical_appointment.scheduled;

import java.util.List;
import java.util.Optional;

import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.auxiliary.BetweenDatesDTO;
import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveSheduledMedicalAppointmentsBetweenDatesByPhysicianService {
    
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String mln, BetweenDatesDTO dto) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician.get())
                    && e.getAvailableDateTime().isAfter(dto.getFirstDate())
                    && e.getAvailableDateTime().isBefore(dto.getLastDate())
                    && e.getCancellationDate() == null
                ).toList()
        );
    }
    
}

