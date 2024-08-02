package org.example.restaurantkiosk.restaurant.menu;

import java.util.Objects;

public class Appetizer implements Menu {

    private final String name;
    private final int price;

    public Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appetizer appetizer = (Appetizer) o;
        return price == appetizer.price && Objects.equals(name, appetizer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
