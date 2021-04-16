package com.company.exception;

import lombok.Data;

public class ValidationException extends RuntimeException {
    private  String message;

    public ValidationException(String message) {

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}