package org.example.restaurantkiosk;

public class OrderMenu {

    private final String menuName;
    private final int amount;
    private final int price;

    public OrderMenu(String menuName, int amount, int price) {
        this.menuName = menuName;
        this.amount = amount;
        this.price = price;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }
}
