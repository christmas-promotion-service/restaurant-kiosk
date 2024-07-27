package org.example.restaurantkiosk.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItems {
    private final List<Menu> items = new ArrayList<>();

    public void addItem(Menu item) {
        items.add(item);
    }

    public boolean contains(String name) {
        return items.stream().anyMatch(item -> item.getName().equals(name));
    }

    public boolean isDrink(String name) {
        return items.stream().anyMatch(menu -> menu instanceof Drink && menu.getName().equals(name));
    }

    public void displayItems() {
        items.forEach(System.out::println);
    }
}
