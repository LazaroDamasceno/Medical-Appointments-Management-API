package com.api.v1.generic_interfaces.retrieve_all;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAllWithOneParameter<T, U> {

    ResponseEntity<List<T>> retrieveAll(U u);

}
