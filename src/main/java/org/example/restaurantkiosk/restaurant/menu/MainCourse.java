package org.example.restaurantkiosk.restaurant.menu;

public class MainCourse implements Menu {

    private final String name;
    private final int price;

    public MainCourse(String name, int price) {
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
