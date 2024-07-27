package org.example.restaurantkiosk.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class DrinkItems {
    // 메뉴 열람 및 확장에 용이하도록 일급컬렉션으로 추상화함.
    private List<Drink> drinks = new ArrayList<>();

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public boolean contains(String name) {
        return drinks.stream().anyMatch(drink -> drink.getName().equals(name));
    }

    public void displayDrinks() {
        drinks.forEach(System.out::println);
    }
}
