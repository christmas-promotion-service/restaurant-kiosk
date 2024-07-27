package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.exception.ServiceException;

import java.util.Scanner;


public class ReservationDayHandler {

    public int getReservationDayFromUser(String input, Scanner scanner) {
        while (true) {
            try {
                int reservationDay = Integer.parseInt(input);
                if (isValidDate(reservationDay)) {
                    return reservationDay;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 날짜는 숫자여야 합니다.");
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }

    private boolean isValidDate(int reservationDay) {
        if (reservationDay >= 1 && reservationDay <= 31) {
            return true;
        } else {
            throw new ServiceException("잘못된 입력입니다. 날짜는 1~31 사이의 숫자여야 합니다.");
        }
    }
}
