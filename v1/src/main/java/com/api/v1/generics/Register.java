package com.api.v1.generics;

import org.springframework.http.ResponseEntity;

public interface Register<ParameterType> {

    ResponseEntity<Void> register(ParameterType dto);

}
