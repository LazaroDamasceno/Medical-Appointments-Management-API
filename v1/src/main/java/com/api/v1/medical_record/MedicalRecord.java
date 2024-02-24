package com.api.v1.medical_record;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "v1_medical_record")
public class MedicalRecord {

    @Id
    private final UUID id = UUID.randomUUID();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private Physician physician;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_appointments")
    private List<MedicalAppointment> medicalAppointments = new ArrayList<>();

    MedicalRecord(Physician physician, Patient patient) {
        this.physician = physician;
        this.patient = patient;
    }

    public MedicalRecord() {
    }
    
}
