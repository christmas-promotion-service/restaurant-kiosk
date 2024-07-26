package org.example.restaurantkiosk;

import java.util.List;
import java.util.Objects;

public interface TotalCostCalculator {
    int calculate(List<OrderMenu> orderMenus); // 할인 금액 계산

}
