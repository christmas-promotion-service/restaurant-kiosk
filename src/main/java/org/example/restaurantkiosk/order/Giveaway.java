package org.example.restaurantkiosk.order;

public enum Giveaway {
    CHAMPAGNE("샴페인")
    ;


    private final String description;

    Giveaway(String description) {
        this.description = description;
    }

    public Giveaway getGiveaway() {
        return CHAMPAGNE;
    }
}
