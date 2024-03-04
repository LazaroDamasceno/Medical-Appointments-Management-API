package com.api.v4.medical_appointment.add_notes;

import com.api.v4.medical_appointment.MedicalAppointment;
import com.api.v4.medical_appointment.MedicalAppointmentRepository;
import com.api.v4.medical_appointment.RetrieveMedicalAppointmentService;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v4.medical_record.AddMedicalAppointmentToMedicalRecordService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddNotesToMedicalAppointmentService {

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
