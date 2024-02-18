package com.api.v1.generics;

public interface Retrieve<Type, ParameterType> {

    Type retrieve(ParameterType parameter);

}
