package com.api.v3.medical_appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v3.patient.Patient;
import com.api.v3.physician.Physician;
import com.api.v3.auxiliaries.dtos.DateTimeDTO;
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
@Table(name = "v3_medical_appointment")
@Data
public class MedicalAppointment {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime availableDateTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDate cancellationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String medicalNotes;

    public MedicalAppointment(Physician physician, Patient patient, DateTimeDTO dto) {
        this.availableDateTime = dto.get();
        this.physician = physician;
        this.patient = patient;
    }

    protected MedicalAppointment() {
    }
    
}
