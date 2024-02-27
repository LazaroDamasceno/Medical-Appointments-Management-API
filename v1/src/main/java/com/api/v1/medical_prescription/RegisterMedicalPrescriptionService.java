package com.api.v1.medical_prescription;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.RetrieveMedicalAppointmentByPatientAndDateService;
import com.api.v1.patient.Patient;
import com.api.v1.patient.RetrievePatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterMedicalPrescriptionService {

    private final MedicalPrescriptionRepository repository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrievePatientBySsnService retrievePatientBySsn;
    private final RetrieveMedicalAppointmentByPatientAndDateService retrieveMedicalAppointmentByPatientAndDate;

    public ResponseEntity<Void> register(String mln, String ssn, MedicalPrescriptionDTO prescriptionDTO) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<Patient> patient = retrievePatientBySsn.retrieve(ssn);
        if (patient.isEmpty()) return ResponseEntity.badRequest().build();

        Optional<MedicalAppointment> medicalAppointmentOptional = retrieveMedicalAppointmentByPatientAndDate
                .retrieve(ssn, new DateTimeDTO(prescriptionDTO.dateTime()));
        if (medicalAppointmentOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();

        MedicalPrescription medicalPrescription = new MedicalPrescription(physician.get(), patient.get(), medicalAppointment, prescriptionDTO);
        repository.save(medicalPrescription);

        medicalAppointment.getMedicalPrescriptions().add(medicalPrescription);
        medicalAppointmentRepository.save(medicalAppointment);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
