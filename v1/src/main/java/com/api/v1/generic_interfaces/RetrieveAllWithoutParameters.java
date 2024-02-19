package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAllWithoutParameters<Type> {

    ResponseEntity<List<Type>> retriveAll();

}
