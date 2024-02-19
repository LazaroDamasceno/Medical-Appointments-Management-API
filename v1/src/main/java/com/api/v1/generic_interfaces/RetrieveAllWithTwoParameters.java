package com.api.v1.generic_interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAllWithTwoParameters<T, U, Z> {

    ResponseEntity<List<T>> retrieveAll(U u, Z z);

}
