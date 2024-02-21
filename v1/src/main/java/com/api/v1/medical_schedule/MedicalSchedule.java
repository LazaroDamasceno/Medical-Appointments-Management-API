package com.api.v1.medical_schedule;

import com.api.v1.medical_slot.MedicalSlot;
import com.api.v1.physician.Physician;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_slots_id")
    private List<MedicalSlot> medicalSlots = new ArrayList<>();

    public MedicalSchedule(Physician physician) {
        this.physician = physician;
    }

    protected MedicalSchedule() {
    }

}
