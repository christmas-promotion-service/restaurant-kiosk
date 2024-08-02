package org.example.restaurantkiosk.io;

import java.util.Map;

public interface OutputHandler {

    void askReservationDayComments();
    void askMenuAndAmountComments();
    void benifitPreviewComments(int day, Map<String, Integer> orderItems, int totalPriceBeforeDiscount);

    void showGiveawayComments(String giveaway);
}
