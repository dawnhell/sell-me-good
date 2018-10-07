package com.vklochkov.utils;

public class InvalidInputException extends Exception {
    private String errorDetails;

    public InvalidInputException(String reason, String errorDetails) {
        super(reason);
        this.errorDetails = errorDetails;
    }

    public String getErrorDetails() {
        return errorDetails;
    }
}
