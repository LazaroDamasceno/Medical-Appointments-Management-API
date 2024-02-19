package com.api.v1.generics;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAllWithoutParameters<Type> {

    ResponseEntity<List<Type>> retriveAll();

}
