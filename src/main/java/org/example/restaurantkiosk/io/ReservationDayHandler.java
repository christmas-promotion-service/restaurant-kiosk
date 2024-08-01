package org.example.restaurantkiosk.io;

import org.example.restaurantkiosk.exception.CustomException;

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
                System.out.println("[ERROR] 잘못된 입력입니다. 날짜는 숫자로 입력해주세요.");
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
