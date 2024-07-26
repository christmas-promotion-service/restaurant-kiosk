package org.example.restaurantkiosk;

import org.example.restaurantkiosk.config.ServiceConfig;
import org.example.restaurantkiosk.io.ConsoleInputHandler;
import org.example.restaurantkiosk.io.ConsoleOutputHandler;
import org.example.restaurantkiosk.restaurant.Restaurant;

public class RestaurantKioskApplication {

    public static void main(String[] args) {
        ServiceConfig serviceConfig = new ServiceConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );

        Restaurant restaurant = new Restaurant(serviceConfig);
        restaurant.initialize();
        restaurant.run();
//        TotalCostCalculator totalCostCalculator = new FixTotalCostCalculator();
//        int calculateMoney = totalCostCalculator.calculate(List.of(
//                new OrderMenu("타파스", 1, 1000),
//                new OrderMenu("제로콜라", 1, 2000)
//        ));
//        System.out.println(calculateMoney);
//
//        FreeGiftService freeGiftService = new FreeGiftService(totalCostCalculator);
//        String freeGift = freeGiftService.chooseFreeGift(calculateMoney);
//        System.out.println("증정품: " + freeGift);
    }

}
