package com.api.v1.system_user.retrieve_by_ssn;

import com.api.v1.facade.Facade;
import com.api.v1.generics.RetrieveWithOneParameter;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveOptionalOfSystemUserService implements RetrieveWithOneParameter<Optional<SystemUser>, String> {

    private final SystemUserRepository repository;

    public Optional<SystemUser> retrieve(String ssn) {
        BigInteger bigInteger = Facade.turnToBigInteger(ssn);
        return repository.findBySsn(bigInteger);
    }

}
