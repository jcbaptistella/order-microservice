package com.softexpert.calculatorms.exception;

public enum ErrorMessage {

    VALUE_ERROR("VALUE_ERROR", "The value item is null.");

    private String code;
    private String message;

    ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
