package com.api.v3.physician;

import com.api.v3.system_user.SystemUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "v3_physician")
@Data
public class Physician {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private @Pattern(regexp = "[0-9]{7}") String mln;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate inductionDate = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate terminationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "system_user_is")
    private SystemUser systemUser;

    Physician(RegisterPhysicianDTO dto) {
        this.mln = dto.mln();
        this.systemUser = new SystemUser(dto.systemUserDTO());
    }

    protected Physician() {
    }

}
