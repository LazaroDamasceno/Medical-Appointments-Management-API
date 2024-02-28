package com.api.v2.medical_appointment.add_notes;

import java.util.Optional;

import com.api.v2.medical_appointment.MedicalAppointment;
import com.api.v2.medical_appointment.MedicalAppointmentRepository;
import com.api.v2.medical_appointment.RetrieveMedicalAppointmentByPhysicianAndDateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v2.medical_record.AddMedicalAppointmentToMedicalRecordService;
import com.api.v2.physician.Physician;
import com.api.v2.physician.RetrievePhysicianByMlnService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddNotesToMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final RetrievePhysicianByMlnService retrievePhysicianByMln;
    private final RetrieveMedicalAppointmentByPhysicianAndDateService retrieveMedicalAppointmentsByPhysicianAndDate;
    private final AddMedicalAppointmentToMedicalRecordService addMedicalAppointmentToMedicalRecord;

    public ResponseEntity<Void> add(String mln, MedicalNotesDTO medicalNotesDTO) {
        Optional<Physician> physician = retrievePhysicianByMln.retrieve(mln);
        Optional<MedicalAppointment> medicalAppointmentOptional = retrieveMedicalAppointmentsByPhysicianAndDate
                .retrieve(mln, medicalNotesDTO.dateTimeDTO());
        if (medicalAppointmentOptional.isEmpty() || physician.isEmpty()) return ResponseEntity.badRequest().build();
        MedicalAppointment medicalAppointment = medicalAppointmentOptional.get();
        medicalAppointment.setMedicalNotes(medicalNotesDTO.notes());
        repository.save(medicalAppointment);
        addMedicalAppointmentToMedicalRecord.add(medicalAppointment.getPatient(), medicalAppointment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
