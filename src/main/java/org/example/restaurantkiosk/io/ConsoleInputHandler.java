package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.order.Order;
import org.example.restaurantkiosk.exception.CustomException;
import org.example.restaurantkiosk.order.OrderParser;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    // 입력 자체의 예외 처리는 여기서 담당
    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int getReservationDayFromUser() {
        String input = SCANNER.nextLine();
        return getReservationDayFromUser(input, SCANNER);
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

    public int getReservationDayFromUser(String input, Scanner scanner) {
        while (true) {
            try {
                int reservationDay = Integer.parseInt(input);
                if (isValidDate(reservationDay)) {
                    return reservationDay;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }

    private boolean isValidDate(int reservationDay) {
        if (reservationDay >= 1 && reservationDay <= 31) {
            return true;
        } else {
            throw new CustomException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
