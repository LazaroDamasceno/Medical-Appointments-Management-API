package com.api.v4.medical_appointment.add_notes;

import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v4/medical-appointment")
@AllArgsConstructor
public class AddNotesToMedicalAppointmentController {

    private final AddNotesToMedicalAppointmentService service;

    @PostMapping("medical-notes/{mln}")
    public ResponseEntity<Void> add(@PathVariable @Pattern(regexp = "[0-9]{7}") String mln, @RequestBody MedicalNotesDTO medicalNotesDTO) {
        return service.add(mln, medicalNotesDTO);
    }
    
}
