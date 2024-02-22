package com.api.v1.physician.terminate;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TerminatePhysicianService {

    private final PhysicianRepository repository;

    public ResponseEntity<Void> terminate(String mln) {
        Optional<Physician> optional = repository.findByMln(mln);
        if (optional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = optional.get();
        physician.setTerminationDate(LocalDate.now());
        repository.save(physician);
        return ResponseEntity.noContent().build();
    }
}
