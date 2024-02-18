package com.api.v1.system_user;

import com.api.v1.generics.Retrieve;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("ai/v1/system-user")
@AllArgsConstructor
public class GetOptionalOfSystemUserController implements Retrieve<Optional<SystemUser>, Long> {

    private final GetOptionalOfSystemUserService service;

    @Override
    @GetMapping("{ssn}")
    public Optional<SystemUser> retrieve(@PathVariable Long ssn) {
        return service.retrieve(ssn);
    }

}
