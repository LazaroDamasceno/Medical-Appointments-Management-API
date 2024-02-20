package com.api.v1.medical_slot.retrieve_all_by_physician;

import com.api.v1.generic_interfaces.retrieve_all.RetrieveAllWithOneParameter;
import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.medical_slot.MedicalSlotRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveAllMedicalShotsByPhysicianService implements RetrieveAllWithOneParameter<MedicalSlot, String> {

    private final MedicalSlotRepository repository;
    private final PhysicianRepository physicianRepository;


    @Override
    public ResponseEntity<List<MedicalSlot>> retrieveAll(String mln) {
        Optional<Physician> physicianOptional = physicianRepository.findByMln(new BigInteger(mln));
        if (physicianOptional.isEmpty()) return ResponseEntity.badRequest().build();
        Physician physician = physicianOptional.get();
        return ResponseEntity.ok(
                repository
                        .findAll()
                        .stream()
                        .filter(e -> e.getPhysician().equals(physician))
                        .toList()
        );
    }
}
