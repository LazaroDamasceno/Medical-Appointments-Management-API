package com.api.v1.medical_prescription;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.DateTimeDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-prescription")
@AllArgsConstructor
public class RetrieveMedicalPrescriptionByMedicalAppointmentControlller {

    private final RetrieveMedicalPrescriptionByMedicalAppointmentService service;

    @GetMapping("{mln}")
    public ResponseEntity<MedicalPrescription> retrieve(@PathVariable String mln, @RequestBody DateTimeDTO dto) {
        return service.retrieve(mln, dto);
    }
    
}
