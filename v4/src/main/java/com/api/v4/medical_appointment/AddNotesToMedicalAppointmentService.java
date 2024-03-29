package com.api.v4.medical_appointment;

import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.medical_record.AddMedicalAppointmentToMedicalRecordService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class AddNotesToMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final RetrieveMedicalAppointmentService retrieveMedicalAppointment;
    private final AddMedicalAppointmentToMedicalRecordService addMedicalAppointmentToMedicalRecord;

    public ResponseEntity<Void> add(@Pattern(regexp = "[0-9]{7}") String mln, MedicalNotesDTO medicalNotesDTO) {
        MedicalAppointment medicalAppointment = retrieveMedicalAppointment.retrieveByPhysician(mln, medicalNotesDTO.dateTimeDTO());
        medicalAppointment.setMedicalNotes(medicalNotesDTO.notes());
        repository.save(medicalAppointment);
        addMedicalAppointmentToMedicalRecord.add(medicalAppointment.getPatient(), medicalAppointment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
