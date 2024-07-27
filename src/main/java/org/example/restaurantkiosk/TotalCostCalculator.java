package org.example.restaurantkiosk;

import java.util.List;

public interface TotalCostCalculator {
    int calculate(List<Order> orders); // 할인 금액 계산

}
