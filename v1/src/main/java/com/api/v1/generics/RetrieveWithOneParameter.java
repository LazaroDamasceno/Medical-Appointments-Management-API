package com.api.v1.generics;

public interface RetrieveWithOneParameter<Type, ParameterType> {

    Type retrieve(ParameterType parameter);

}
