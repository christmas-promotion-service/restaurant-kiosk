package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.Order;

public interface InputHandler {

    int getReservationDayFromUser();

    Order getOrderMenuFromUser();
}
