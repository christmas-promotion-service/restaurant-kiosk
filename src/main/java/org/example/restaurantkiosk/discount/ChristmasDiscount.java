package org.example.restaurantkiosk.discount;

public class ChristmasDiscount implements DiscountPolicy {

    private final int DISCOUNT_PER_DAY = 100;
    private final int MINIMUM_DISCOUNT = 1000;
    @Override
    public int calculateFee() {
        return 0;
    }

    public String calculateFee(int totalPrice, int reservationDay) {
        if (reservationDay > 25) {
            return "없음";
        }

        int totalDiscount = MINIMUM_DISCOUNT + (reservationDay - 1) * DISCOUNT_PER_DAY;
        return String.valueOf(totalDiscount);
    }
}
