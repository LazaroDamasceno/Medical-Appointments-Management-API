package com.api.v1.generics;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAllWithTwoArguments<T, U, Z> {

    ResponseEntity<List<T>> retrieveAll(U u, Z z);

}
