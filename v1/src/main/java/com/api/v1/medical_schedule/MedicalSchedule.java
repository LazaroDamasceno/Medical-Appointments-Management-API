package com.api.v1.medical_schedule;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "v1_medical_schedule")
@Data
public class MedicalSchedule {

    @Id
    private final UUID id = UUID.randomUUID();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private Physician physician;

    MedicalSchedule(Physician physician) {
        this.physician = physician;
    }

    protected MedicalSchedule() {
    }

}
