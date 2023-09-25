package com.softexpert.calculatorms.exception;

public class GenericException extends RuntimeException {

    public GenericException(String code, String message) {
        super(String.format(code + ": " + message));
    }
}
