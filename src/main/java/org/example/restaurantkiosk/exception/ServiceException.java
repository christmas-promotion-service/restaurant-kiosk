package org.example.restaurantkiosk.exception;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super("[ERROR] " + message);
    }
}