package com.api.v3.medical_slot;

import com.api.v3.medical_appointment.MedicalAppointment;
import com.api.v3.physician.Physician;
import com.api.v3.auxiliaries.DateTimeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "v3_medical_slot")
@Data
public class MedicalSlot {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime availableDateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physicin_id")
    private Physician physician;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_appointment_id")
    private MedicalAppointment medicalAppointment;

    MedicalSlot(Physician physician, DateTimeDTO dto) {
        this.physician = physician;
        this.availableDateTime = dto.get();
    }

    protected MedicalSlot() {
    }

}
