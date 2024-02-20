package com.api.v1.physician;

import com.api.v1.medical_schedule.MedicalSchedule;
import com.api.v1.physician.register.RegisterPhysicianDTO;
import com.api.v1.system_user.CreateInstanceOfSystemUser;
import com.api.v1.system_user.SystemUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "v1_physician")
@Data
public class Physician {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private BigInteger mln;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate inductionDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate terminationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private SystemUser systemUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_schedule_id")
    private MedicalSchedule medicalSchedule;

    Physician(RegisterPhysicianDTO dto) {
        this.mln = new BigInteger(dto.mln());
        this.systemUser = CreateInstanceOfSystemUser.create(dto.systemUserDTO());
    }

    protected Physician() {
    }

}
