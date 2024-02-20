package com.api.v1.generic_interfaces.register;

import org.springframework.http.ResponseEntity;

public interface RegisterWithTwoParameters<T, U> {

    ResponseEntity<Void> register(T t, U u);

}
