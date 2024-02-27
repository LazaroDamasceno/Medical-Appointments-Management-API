package com.api.v1.medical_appointment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@AllArgsConstructor
public class AddNotesToMedicalAppointmentController {

    private final AddNotesToMedicalAppointmentService service;

    @PostMapping("medical-notes/{mln}")
    public ResponseEntity<Void> add(@PathVariable String mln,
                                    @RequestBody DateTimeDTO dateTimeDTO, 
                                    @RequestBody MedicalNotesDTO medicalNotesDTO) {
        return service.add(mln, dateTimeDTO, medicalNotesDTO);
    }
    
}
