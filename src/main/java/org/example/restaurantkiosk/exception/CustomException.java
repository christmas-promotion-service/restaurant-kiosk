package org.example.restaurantkiosk.exception;

public class CustomException extends IllegalArgumentException {
    public CustomException(String message) {
        super("[ERROR] " + message);
    }
}