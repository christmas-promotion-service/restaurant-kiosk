package org.example.restaurantkiosk.restaurant.menu;

public class Dessert implements Menu {

    private final String name;
    private final int price;

    public Dessert(String name, int price) {
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

}
