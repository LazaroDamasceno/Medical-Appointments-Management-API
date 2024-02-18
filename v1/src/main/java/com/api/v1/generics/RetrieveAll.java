package com.api.v1.generics;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAll<Type> {

    ResponseEntity<List<Type>> retriveAll();

}
