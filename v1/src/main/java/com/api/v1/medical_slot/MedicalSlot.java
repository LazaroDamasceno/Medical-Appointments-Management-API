package com.api.v1.medical_slot;

import com.api.v1.facade.Facade;
import com.api.v1.physician.Physician;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "v1_medical_slot")
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

    MedicalSlot(Physician physician, AvaliableDateTimeDTO dto) {
        this.physician = physician;
        this.availableDateTime = Facade.convertStringToDateTime(dto.availableDateTime());
    }

    protected MedicalSlot() {
    }

}
