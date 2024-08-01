package org.example.restaurantkiosk.restaurant;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.User;
import org.example.restaurantkiosk.config.ServiceConfig;
import org.example.restaurantkiosk.exception.CustomException;
import org.example.restaurantkiosk.io.InputHandler;
import org.example.restaurantkiosk.io.OutputHandler;
import org.example.restaurantkiosk.restaurant.menu.*;

public class Restaurant implements RestaurantInitializable, RestaurantRunnable {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private ServiceStatus serviceStatus;
    private MenuItems menuItems;

    private User user;

    public Restaurant(ServiceConfig serviceConfig) {
        this.inputHandler = serviceConfig.getInputHandler();
        this.outputHandler = serviceConfig.getOutputHandler();
    }

    @Override
    public void initialize() {
        // 서비스 상태 on
        initializeServiceStatus();
        // 메뉴 데이터 세팅
        initializeMenuItems();
    }

    private void initializeMenuItems() {
        MenuInitializer menuInitializer = new MenuInitializer();
        this.menuItems = menuInitializer.initializeMenu();

    }

    @Override
    public void run() {
        try {
            outputHandler.askReservationDayComments();
            int reservationDay = inputHandler.getReservationDayFromUser();

            outputHandler.askMenuAndAmountComments();
            Order order = inputHandler.getOrderMenuFromUser(menuItems);
            // User에 받아온 값을 토대로 생성자 만들기
            User user = new User(reservationDay, order);

            int totalPrice = order.calculateTotalPrice();
            outputHandler.benifitPreviewComments(reservationDay, user.getOrderItems(), totalPrice);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initializeServiceStatus() {
        serviceStatus = ServiceStatus.IN_PROGRESS;
    }

    private boolean isInProgress() {
        return serviceStatus == ServiceStatus.IN_PROGRESS;
    }

}
