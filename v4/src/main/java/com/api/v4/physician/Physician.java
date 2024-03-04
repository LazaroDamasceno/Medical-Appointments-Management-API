package com.api.v4.physician;

import com.api.v4.system_user.SystemUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "v4_physician")
@Data
public class Physician  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private final UUID id = UUID.randomUUID();
    
    @Column(nullable = false)
    private String mln;

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
