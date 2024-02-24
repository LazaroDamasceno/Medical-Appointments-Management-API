package com.api.v1.medical_appointment;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.medical_record.MedicalRecord;
import com.api.v1.medical_record.MedicalRecordRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddNotesToMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrieveMedicalAppointmentsByPhysicianAndDateService retrieveMedicalAppointmentsByPhysicianAndDate;

    public ResponseEntity<Void> add(String mln, DateTimeDTO dateTime, MedicalNotesDTO medicalNotes) {

        Optional<MedicalAppointment> medicalAppointmentOptional = retrieveMedicalAppointmentsByPhysicianAndDate.retrieve(mln, dateTime);
        if (medicalAppointmentOptional.isPresent() 
            && medicalAppointmentOptional.get().getMedicalNotes() != null) return ResponseEntity.badRequest().build();


        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();

        if (medicalAppointmentOptional.isEmpty()) return ResponseEntity.badRequest().build();

        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();
        medicalAppointment.setMedicalNotes(medicalNotes.notes());
        repository.save(medicalAppointment);

        Optional<MedicalRecord> medicalRecordOptional = medicalRecordRepository.findByPatient(medicalAppointment.getPatient());
        if (medicalRecordOptional.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalRecord medicalRecord = medicalRecordOptional.get();
        medicalRecord.getMedicalAppointments().add(medicalAppointment);
        medicalRecordRepository.save(medicalRecord);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
