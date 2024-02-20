package com.api.v1.generic_interfaces.retrieve;

public interface RetrieveWithOneParameter<Type, ParameterType> {

    Type retrieve(ParameterType parameter);

}
