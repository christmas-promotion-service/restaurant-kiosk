package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

public interface InputHandler {

    int getReservationDayFromUser();

    Order getOrderMenuFromUser(MenuItems menuItems);
}
