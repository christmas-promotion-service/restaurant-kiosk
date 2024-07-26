package org.example.restaurantkiosk;

import java.util.List;

public class RestaurantKioskApplication {

    public static void main(String[] args) {
        TotalCostCalculator totalCostCalculator = new FixTotalCostCalculator();
        int calculateMoney = totalCostCalculator.calculate(List.of(
                new OrderMenu("타파스", 1, 1000),
                new OrderMenu("제로콜라", 1, 2000)
        ));
        System.out.println(calculateMoney);

        FreeGiftService freeGiftService = new FreeGiftService(totalCostCalculator);
        String freeGift = freeGiftService.chooseFreeGift(calculateMoney);
        System.out.println("증정품: " + freeGift);
    }

}
