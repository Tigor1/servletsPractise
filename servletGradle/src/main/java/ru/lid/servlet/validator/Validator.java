package ru.lid.servlet.validator;

public interface Validator<T> {
    ValidationResult isValid(T object);
}
