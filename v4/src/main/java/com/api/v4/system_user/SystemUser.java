package com.api.v4.system_user;

import com.api.v4.auxiliaries.DateDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "v4_system_user")
@Data
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private final UUID id = UUID.randomUUID();
    
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private @Pattern(regexp = "[0-9]{9}") String ssn;

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
