package com.api.v1.system_user.retrieve;

import com.api.v1.generics.Retrieve;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.SystemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RetrieveOptionalOfSystemUserService implements Retrieve<Optional<SystemUser>, Long> {

    private final SystemUserRepository repository;

    public Optional<SystemUser> retrieve(Long parameter) {
        BigInteger bigInteger = BigInteger.valueOf(parameter);
        return repository.findBySsn(bigInteger);
    }

}
