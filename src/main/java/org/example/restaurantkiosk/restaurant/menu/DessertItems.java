package org.example.restaurantkiosk.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class DessertItems {
    private final List<Dessert> desserts = new ArrayList<>();

    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
    }

    public boolean contains(String name) {
        return desserts.stream().anyMatch(dessert -> dessert.getName().equals(name));
    }

    public void displayAppetizers() {
        desserts.forEach(System.out::println);
    }
}
