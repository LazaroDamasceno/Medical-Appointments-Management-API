package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.BetweenDatesDTO;
import com.api.v1.auxiliary.ConvertToDateTime;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveFinishedMedicalAppointmentBetweenDatesByPhysicianService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String mln, BetweenDatesDTO dto) {
        LocalDateTime firstDate = ConvertToDateTime.convert(dto.firstDate());
        LocalDateTime lastDate = ConvertToDateTime.convert(dto.lastDate());
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician.get())
                    && e.getAvailableDateTime().isAfter(firstDate)
                    && e.getAvailableDateTime().isBefore(lastDate)
                    && e.getMedicalNotes() == null
                ).toList()
        );
    }
    
}
