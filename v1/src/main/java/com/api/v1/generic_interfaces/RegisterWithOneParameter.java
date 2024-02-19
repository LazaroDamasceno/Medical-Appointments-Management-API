package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

public interface RegisterWithOneParameter<DtoType> {

    ResponseEntity<Void> register(DtoType dto);

}
