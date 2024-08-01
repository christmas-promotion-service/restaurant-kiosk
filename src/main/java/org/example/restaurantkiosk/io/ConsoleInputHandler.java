package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.parser.OrderParser;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    // 입력 자체의 예외 처리는 여기서 담당
    public static final Scanner SCANNER = new Scanner(System.in);
    private final ReservationDayHandler reservationDayHandler = new ReservationDayHandler();

    @Override
    public int getReservationDayFromUser() {
        String input = SCANNER.nextLine();
        return reservationDayHandler.getReservationDayFromUser(input, SCANNER);
    }

    @Override
    public Order getOrderMenuFromUser(MenuItems menuItems) {
        String input = SCANNER.nextLine();
        return getOrderMenuFromUser(input, menuItems);
    }

    public Order getOrderMenuFromUser(String input, MenuItems menuItems) {
        while (true) {
            OrderParser orderParser = new OrderParser(menuItems);
            Order order = orderParser.parseOrder(input);
            order.validate();
            return order;
        }
    }
}
