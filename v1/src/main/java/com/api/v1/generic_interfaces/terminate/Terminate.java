package com.api.v1.generic_interfaces.terminate;

import org.springframework.http.ResponseEntity;

public interface Terminate {

    ResponseEntity<Void> terminate(String registrationNumber);

}
