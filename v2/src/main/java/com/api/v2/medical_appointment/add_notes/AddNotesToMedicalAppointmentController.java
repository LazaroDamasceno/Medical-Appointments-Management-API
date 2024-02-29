package com.api.v2.medical_appointment.add_notes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/medical-appointment")
@AllArgsConstructor
public class AddNotesToMedicalAppointmentController {

    private final AddNotesToMedicalAppointmentService service;

    @PatchMapping("medical-notes/{mln}")
    public ResponseEntity<Void> add(@PathVariable String mln, @RequestBody MedicalNotesDTO medicalNotesDTO) {
        return service.add(mln, medicalNotesDTO);
    }
    
}
