package com.api.v1.generics;

public interface Register<Type, ParameterType> {

    Type register(ParameterType parameter);

}
