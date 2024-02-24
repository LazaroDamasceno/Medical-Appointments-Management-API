package com.api.v1.medical_prescription;

import java.time.LocalDate;
import java.util.UUID;

import com.api.v1.medical_appointment.MedicalAppointment;
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
@Table(name = "v1_medical_prescription")
@Data
public class MedicalPrescription {

    @Id
    private final UUID id = UUID.randomUUID();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate creationDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate dueDate = LocalDate.now().plusDays(30);

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_appointment_id")
    private MedicalAppointment medicalAppointment;

    @Column(nullable = false)
    private String prescription;

    public MedicalPrescription(Physician physician, Patient patient, MedicalAppointment medicalAppointment,
            MedicalPrescriptionDTO dto) {
        this.physician = physician;
        this.patient = patient;
        this.medicalAppointment = medicalAppointment;
        this.prescription = dto.prescription();
    }

    public MedicalPrescription() {
    }
    
}
