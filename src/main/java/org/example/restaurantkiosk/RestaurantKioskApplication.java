package org.example.restaurantkiosk;

import org.example.restaurantkiosk.config.ServiceConfig;
import org.example.restaurantkiosk.io.ConsoleInputHandler;
import org.example.restaurantkiosk.io.ConsoleOutputHandler;
import org.example.restaurantkiosk.restaurant.Restaurant;
import org.example.restaurantkiosk.restaurant.menu.MenuInitializer;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

public class RestaurantKioskApplication {

    public static void main(String[] args) {
        MenuInitializer menuInitializer = new MenuInitializer();
        MenuItems menuItems = menuInitializer.initializeMenu();

        ServiceConfig serviceConfig = new ServiceConfig(
                new ConsoleInputHandler(menuItems),
                new ConsoleOutputHandler()
        );

        Restaurant restaurant = new Restaurant(serviceConfig);
        restaurant.initialize();
        restaurant.run();
    }

}
