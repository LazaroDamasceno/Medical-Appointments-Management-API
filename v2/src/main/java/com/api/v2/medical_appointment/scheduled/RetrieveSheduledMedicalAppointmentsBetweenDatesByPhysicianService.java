package com.api.v2.medical_appointment.scheduled;

import java.util.List;

import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.auxiliary.BetweenDatesDTO;
import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveSheduledMedicalAppointmentsBetweenDatesByPhysicianService {
    
    private final RetrievePhysicianService retrievePhysician
;
    private final MedicalAppointmentRepository repository;

    public ResponseEntity<List<MedicalAppointment>> retrieve(String mln, BetweenDatesDTO dto) {
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

