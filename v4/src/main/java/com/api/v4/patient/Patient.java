package com.api.v4.patient;

import com.api.v4.system_user.SystemUser;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "v4_patient")
@Data
class Patient  implements Serializable {

    private static final long serialVersionUID = 1L;

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
