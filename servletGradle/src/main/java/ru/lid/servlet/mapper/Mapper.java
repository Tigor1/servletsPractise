package ru.lid.servlet.mapper;

public interface Mapper<F, T> {

     T mapFrom(F object);
}
