package ru.lid.servlet.exception;

import lombok.Getter;
import ru.lid.servlet.validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException {

    @Getter
    private final List<Error> errors;


    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
