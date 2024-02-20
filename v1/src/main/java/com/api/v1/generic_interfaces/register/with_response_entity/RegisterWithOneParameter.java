package com.api.v1.generic_interfaces.register.with_response_entity;

import org.springframework.http.ResponseEntity;

public interface RegisterWithOneParameter<DtoType> {

    ResponseEntity<Void> register(DtoType dto);

}
