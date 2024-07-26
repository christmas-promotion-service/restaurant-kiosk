package org.example.restaurantkiosk;

public class FreeGiftService {
    private TotalCostCalculator totalCostCalculator;

    public FreeGiftService(TotalCostCalculator totalCostCalculator) {
        this.totalCostCalculator = totalCostCalculator;
    }

    public String chooseFreeGift (int cost) {
        if (cost >= 120000) {
            return "샴페인";
        }
        return "없음";
    }
}
