package com.api.v1.medical_prescription;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.RetrieveMedicalAppointmentByPatientAndDateService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrieveMedicalPrescriptionByMedicalAppointmentService {

    private final MedicalPrescriptionRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrieveMedicalAppointmentByPatientAndDateService retrieveMedicalAppointmentByPatientAndDate;

    public ResponseEntity<MedicalPrescription> retrieve(String mln, DateTimeDTO dto) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<MedicalAppointment> medicalAppointment = retrieveMedicalAppointmentByPatientAndDate.retrieve(mln, dto);
        if (medicalAppointment.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<MedicalPrescription> medicalPrescription = repository.findByMedicalAppointment(medicalAppointment.get());

        return medicalPrescription
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    
}
