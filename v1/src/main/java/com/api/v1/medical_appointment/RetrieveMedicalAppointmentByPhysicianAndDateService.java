package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.ConvertToDateTime;
import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalAppointmentByPhysicianAndDateService {

    private final MedicalAppointmentRepository repository;
    private final PhysicianRepository physicianRepository;

    public Optional<MedicalAppointment> retrieve(String mln, DateTimeDTO dto) {
        LocalDateTime localDateTime = ConvertToDateTime.convert(dto.dateTime());
        Optional<Physician> physician = physicianRepository.findByMln(mln);
        if (physician.isEmpty()) return Optional.empty();
        return repository
                .findAll()
                .stream()
                .filter(e -> e.getAvailableDateTime().equals(localDateTime) 
                    && e.getPhysician().equals(physician.get())
                ).findAny();
    }
    
}
