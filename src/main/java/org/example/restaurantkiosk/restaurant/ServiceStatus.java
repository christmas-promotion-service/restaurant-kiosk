package org.example.restaurantkiosk.restaurant;

public enum ServiceStatus {
    IN_PROGRESS("진행중"),
    EXIT("종료"),
            ;

    private final String description;

    ServiceStatus(String description) {
        this.description = description;
    }
}
