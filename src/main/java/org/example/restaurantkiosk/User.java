package org.example.restaurantkiosk;

import org.example.restaurantkiosk.order.Order;

import java.util.Map;

public class User {
    private int reservationDay;
    private Order order;

    public User(int reservationDay, Order order) {
        this.reservationDay = reservationDay;
        this.order = order;
    }

    public Map<String, Integer> getOrderItems() {
        return order.getOrderItems();
    }
}
