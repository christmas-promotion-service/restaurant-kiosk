package org.example.restaurantkiosk.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class AppetizerItems {
    // 메뉴 열람 및 확장에 용이하도록 일급컬렉션으로 추상화함.
    private final List<Appetizer> appetizers = new ArrayList<>();

    public void addAppetizer(Appetizer appetizer) {
        appetizers.add(appetizer);
    }

    public boolean contains(String name) {
        return appetizers.stream().anyMatch(appetizer -> appetizer.getName().equals(name));
    }

    public void displayAppetizers() {
        appetizers.forEach(System.out::println);
    }
}
