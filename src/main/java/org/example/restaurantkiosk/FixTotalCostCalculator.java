package org.example.restaurantkiosk;

import java.util.List;

public class FixTotalCostCalculator implements TotalCostCalculator {

    @Override
    public int calculate(List<OrderMenu> orderMenus) {
        int result = 0;
        for (int i = 0; i < orderMenus.size(); i++) {
            OrderMenu orderMenu = orderMenus.get(i);
            result += orderMenu.getPrice() * orderMenu.getAmount();
        }
        return result;
    }
}
