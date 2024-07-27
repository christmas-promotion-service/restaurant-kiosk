package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.exception.ServiceException;
import org.example.restaurantkiosk.parser.OrderParser;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.Scanner;

public class OrderInputHandler {

    private final MenuItems menuItems;
    public OrderInputHandler(MenuItems menuItems) {
        this.menuItems = menuItems;
    }

    public Order getOrderMenuFromUser(String input, Scanner scanner) {
        while (true) {
            try {
                OrderParser orderParser = new OrderParser(menuItems);
                Order order = orderParser.parseOrder(input);
                order.validate();
                return order;

            } catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
