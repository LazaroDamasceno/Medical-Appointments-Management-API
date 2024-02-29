package com.api.v3.patient;

import com.api.v3.system_user.SystemUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "v3_patient")
@Data
public class Patient {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String fullAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "system_user_id")
    private SystemUser systemUser;

    Patient(RegisterPatientDTO dto) {
        this.fullAddress = dto.fullAddress();
        this.systemUser = new SystemUser(dto.systemUserDTO());
    }

    protected  Patient() {
    }

}
