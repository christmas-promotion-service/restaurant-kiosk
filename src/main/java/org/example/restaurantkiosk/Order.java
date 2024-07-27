package org.example.restaurantkiosk;

import org.example.restaurantkiosk.exception.ServiceException;
import org.example.restaurantkiosk.restaurant.menu.MenuItems;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final Map<String, Integer> items = new HashMap<>();
    private final MenuItems menuItems;

    public Order(MenuItems menuItems) {
        this.menuItems = menuItems;
    }

    public void addItem(String name, int quantity) {
        items.put(name, quantity);
    }

    public Map<String, Integer> getItems() {
        return new HashMap<>(items);
    }

    public int getTotalQuantity() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    public boolean containsOnlyDrinks() {
        return items.keySet().stream().allMatch(menuItems::isDrink); // "콜라"가 음료의 대표적인 예라고 가정
    }

    // 수량 또는 주문 관련 정책에 대한 예외 처리는 여기서 담당
    public void validate() {
        if (getTotalQuantity() > 20) {
            throw new ServiceException("한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
        if (containsOnlyDrinks()) {
            throw new ServiceException("음료만 주문할 수 없습니다.");
        }
    }
}
