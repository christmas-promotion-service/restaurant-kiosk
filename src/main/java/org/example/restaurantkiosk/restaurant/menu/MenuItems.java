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

    public int getPrice(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .map(Menu::getPrice)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 메뉴를 찾을 수 없습니다: " + name));
    }
}
