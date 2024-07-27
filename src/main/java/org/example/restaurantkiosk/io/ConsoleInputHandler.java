package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    // 입력 자체의 예외 처리는 여기서 담당
    public static final Scanner SCANNER = new Scanner(System.in);
    private final ReservationDayHandler reservationDayHandler = new ReservationDayHandler();
    private final OrderInputHandler orderInputHandler;
    private final MenuItems menuItems;

    public ConsoleInputHandler(MenuItems menuItems) {
        this.menuItems = menuItems;
        orderInputHandler = new OrderInputHandler(menuItems);
    }

    @Override
    public int getReservationDayFromUser() {
        String input = SCANNER.nextLine();
        return reservationDayHandler.getReservationDayFromUser(input, SCANNER);
    }

    @Override
    public Order getOrderMenuFromUser() {
        String input = SCANNER.nextLine();
        return orderInputHandler.getOrderMenuFromUser(input, SCANNER);
    }
}
