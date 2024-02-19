package com.api.v1.generics;

import org.springframework.http.ResponseEntity;

public interface Terminate {

    ResponseEntity<Void> terminate(String registrationNumber);

}
