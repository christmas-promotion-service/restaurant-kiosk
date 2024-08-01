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
    }

}
