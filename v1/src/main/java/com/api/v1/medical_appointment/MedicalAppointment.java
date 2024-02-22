package com.api.v1.medical_appointment;

import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.auxiliary.DateTimeDTO;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "v1_medical_appointment")
@Data
public class MedicalAppointment {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime availableDateTime;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cancelationDateTime;

    private String notes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    MedicalAppointment(Physician physician, Patient patient, DateTimeDTO dto) {
        this.availableDateTime = dto.dateTime();
        this.physician = physician;
        this.patient = patient;
    }
    
}
