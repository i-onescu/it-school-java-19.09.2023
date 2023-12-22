package com.example.demo.converters;

// this is an interface which is meant to be implemented by a concrete class
// so we can convert a type to another type (in our case, a Dto to an entity-annotated class and vice-versa)
public interface ObjectConverter<T, U> {

    T convertSecondToFirst(U u);
    U convertFirstToSecond(T t);
}
