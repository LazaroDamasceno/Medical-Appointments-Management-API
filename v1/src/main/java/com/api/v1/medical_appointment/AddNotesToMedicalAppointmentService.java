package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.medical_record.AddMedicalAppointmentToMedicalRecordService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddNotesToMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrieveMedicalAppointmentByPhysicianAndDateService retrieveMedicalAppointmentsByPhysicianAndDate;
    private final AddMedicalAppointmentToMedicalRecordService adddMedicalAppointmentToMedicalRecord;

    public ResponseEntity<Void> add(String mln, DateTimeDTO dateTime, MedicalNotesDTO medicalNotes) {

        Optional<MedicalAppointment> medicalAppointmentOptional = retrieveMedicalAppointmentsByPhysicianAndDate.retrieve(mln, dateTime);
        if (medicalAppointmentOptional.isPresent() 
            && medicalAppointmentOptional.get().getMedicalNotes() != null) return ResponseEntity.badRequest().build();


        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        if (physician.isEmpty()) return ResponseEntity.badRequest().build();

        if (medicalAppointmentOptional.isEmpty()) return ResponseEntity.badRequest().build();

        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();
        medicalAppointment.setMedicalNotes(medicalNotes.notes());
        medicalAppointment.setFinishingDateTime(LocalDateTime.now());
        repository.save(medicalAppointment);

        adddMedicalAppointmentToMedicalRecord.add(medicalAppointment.getPatient(), medicalAppointment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
