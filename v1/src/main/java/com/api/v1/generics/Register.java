package com.api.v1.generics;

import org.springframework.http.ResponseEntity;

public interface Register<DtoType> {

    ResponseEntity<Void> register(DtoType dto);

}
