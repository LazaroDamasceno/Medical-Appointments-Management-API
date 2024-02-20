package com.api.v1.generic_interfaces.retrieve;

import org.springframework.http.ResponseEntity;

public interface RetrieveWithTwoParameters<T, U, Z> {

    ResponseEntity<T> retrieve(U u, Z z);

}
