package org.example.restaurantkiosk.parser;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.exception.ServiceException;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.Arrays;

public class OrderParser {
    private final MenuItems menuItems;

    public OrderParser(MenuItems menuItems) {
        this.menuItems = menuItems;
    }

    public Order parseOrder(String input) {
        Order order = new Order();

        Arrays.stream(input.split(","))
                .map(this::splitItem)
                .forEach(parts -> {
                    String itemName = parts[0].trim();
                    int quantity = parseAndValidateQuantity(parts[1].trim());

                    validateMenuItem(itemName);
                    order.addItem(itemName, quantity);
                });

        return order;
    }

    private String[] splitItem(String item) {
        String[] parts = item.split("-");
        if (parts.length != 2) {
            throw new ServiceException("잘못된 형식입니다. 메뉴와 수량을 올바르게 입력하세요.");
        }
        return parts;
    }

    private int parseAndValidateQuantity(String quantityStr) {
        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                throw new ServiceException("수량은 1 이상의 숫자여야 합니다.");
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new ServiceException("수량은 숫자여야 합니다.");
        }
    }

    private void validateMenuItem(String itemName) {
        if (!menuItems.contains(itemName)) {
            throw new ServiceException("메뉴에 없는 음식입니다: " + itemName);
        }
    }
}
