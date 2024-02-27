package com.api.v1.system_user;

import com.api.v1.auxiliary.DateDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "v1_system_user")
@Data
public class SystemUser {

    @Id
    private final UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String ssn;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDay;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    public SystemUser(RegisterSystemUserDTO dto) {
        this.fullName = dto.fullName();
        this.ssn = dto.ssn();
        this.birthDay = new DateDTO(dto.birthDay()).get();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
    }

    protected SystemUser() {
    }

}
