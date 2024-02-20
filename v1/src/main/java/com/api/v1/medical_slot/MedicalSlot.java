package com.api.v1.medical_slot;

import com.api.v1.convert_to_datetime.ConvertoToDateTime;
import com.api.v1.date_time_dto.DateTimeDTO;
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

    MedicalSlot(Physician physician, DateTimeDTO dto) {
        this.physician = physician;
        this.availableDateTime = ConvertoToDateTime.convertStringToDateTime(dto.dateTime());
    }

    protected MedicalSlot() {
    }

}
