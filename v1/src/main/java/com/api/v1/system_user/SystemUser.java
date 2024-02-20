package com.api.v1.system_user;

import com.api.v1.facade.Facade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;
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
    private BigInteger ssn;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDay;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private BigInteger phoneNumber;

    SystemUser(RegisterSystemUserDTO dto) {
        this.fullName = dto.fullName();
        this.ssn = Facade.turnToBigInteger(dto.ssn());
        this.birthDay = Facade.convertStringToDate(dto.birthDay());
        this.email = dto.email();
        this.phoneNumber = Facade.turnToBigInteger(dto.phoneNumber());
    }

    protected SystemUser() {
    }

}
