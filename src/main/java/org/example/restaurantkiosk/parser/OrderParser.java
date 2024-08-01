package org.example.restaurantkiosk.parser;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.exception.CustomException;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrderParser {
    private final MenuItems menuItems;

    public OrderParser(MenuItems menuItems) {
        this.menuItems = menuItems;
    }

    public Order parseOrder(String input) {
        Order order = new Order(menuItems);
        Set<String> orderOverlapChecker = new HashSet<>();

        Arrays.stream(input.split(","))
                .map(this::splitItem)
                .forEach(parts -> {
                    String itemName = parts[0].trim();
                    int quantity = parseAndValidateQuantity(parts[1].trim());

                    if (!orderOverlapChecker.add(itemName)) {
                        throw new CustomException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    }

                    validateMenuItem(itemName);
                    order.addItem(itemName, quantity);
                });

        return order;
    }

    private String[] splitItem(String item) {
        String[] parts = item.split("-");
        if (parts.length != 2) {
            throw new CustomException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return parts;
    }

    private int parseAndValidateQuantity(String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                throw new CustomException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new CustomException("수량은 숫자여야 합니다.");
        }
    }

    private void validateMenuItem(String itemName) {
        if (!menuItems.contains(itemName)) {
            throw new CustomException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
