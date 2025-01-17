package org.example.restaurantkiosk.io;

import java.text.NumberFormat;
import java.util.Map;

public class ConsoleOutputHandler implements OutputHandler {

    private NumberFormat numberFormat = new NumberFormat.getInstance();

    @Override
    public void askReservationDayComments() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
                "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    @Override
    public void askMenuAndAmountComments() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    @Override
    public void benifitPreviewComments(int reservationDay, Map<String, Integer> orderItems, int totalPriceBeforeDiscount) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", reservationDay);
        System.out.println();

        System.out.println("<주문 메뉴>");
        orderItems.entrySet().stream()
                .forEach(entry -> System.out.printf("%s %d개%n", entry.getKey(), entry.getValue()));
        System.out.println();

        System.out.println("<할인 전 총주문 금액>");
        String formattedPrice = numberFormat.format(totalPriceBeforeDiscount);
        System.out.printf("%s원%n", formattedPrice);



    }

    @Override
    public void showGiveawayComments(String giveaway) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println(giveaway + " 1개");
    }

    @Override
    public void showChristmasDiscountComments(String christmasDiscountText) {
        if (christmasDiscountText.equals("없음")) {
            System.out.println(christmasDiscountText);
        }
        else {
            String formattedDiscount = numberFormat.format(christmasDiscountText);
            System.out.printf("%s원%n", formattedDiscount);
        }
    }


}
