package org.example.restaurantkiosk.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class DessertItems {
    private final List<Dessert> desserts = new ArrayList<>();

    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
    }

    public void displayDesserts() {
        System.out.println("\n<디저트>");
        for (Dessert dessert : desserts) {
            System.out.println(dessert);
        }
    }
}
