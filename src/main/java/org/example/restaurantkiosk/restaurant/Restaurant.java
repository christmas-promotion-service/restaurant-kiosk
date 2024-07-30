package org.example.restaurantkiosk.restaurant;

import org.example.restaurantkiosk.Order;
import org.example.restaurantkiosk.User;
import org.example.restaurantkiosk.config.ServiceConfig;
import org.example.restaurantkiosk.io.InputHandler;
import org.example.restaurantkiosk.io.OutputHandler;
import org.example.restaurantkiosk.restaurant.menu.*;

public class Restaurant implements RestaurantInitializable, RestaurantRunnable {

    private final AppetizerItems appetizerItems = new AppetizerItems();
    private final MainCourseItems mainCourseItems = new MainCourseItems();
    private final DessertItems dessertItems = new DessertItems();
    private final DrinkItems drinkItems = new DrinkItems();

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private ServiceStatus serviceStatus;

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
//        initializeMenuItems();
    }

    private void initializeMenuItems() {
        initializeAppetizers();
        initializeMainCourses();
        initializeDesserts();
        initializeDrinks();
    }

    @Override
    public void run() {
        outputHandler.askReservationDayComments();
        int reservationDay = inputHandler.getReservationDayFromUser();

        outputHandler.askMenuAndAmountComments();
        Order order = inputHandler.getOrderMenuFromUser();
        // User에 받아온 값을 토대로 생성자 만들기
        User user = new User(reservationDay, order);

        int totalPrice = order.calculateTotalPrice();
        outputHandler.benifitPreviewComments(reservationDay, user.getOrderItems(), totalPrice);

    }

    private void initializeServiceStatus() {
        serviceStatus = ServiceStatus.IN_PROGRESS;
    }

    private void initializeDrinks() {
        drinkItems.addDrink(new Drink("제로콜라", 3000));
        drinkItems.addDrink(new Drink("레드와인", 60000));
        drinkItems.addDrink(new Drink("샴페인", 25000));
    }

    private void initializeDesserts() {
        dessertItems.addDessert(new Dessert("초코케이크", 15000));
        dessertItems.addDessert(new Dessert("아이스크림", 5000));
    }

    private void initializeMainCourses() {
        mainCourseItems.addMainCourse(new MainCourse("티본스테이크", 55000));
        mainCourseItems.addMainCourse(new MainCourse("바비큐립", 54000));
        mainCourseItems.addMainCourse(new MainCourse("해산물파스타", 35000));
        mainCourseItems.addMainCourse(new MainCourse("크리스마스파스타", 25000));
    }

    private void initializeAppetizers() {
        appetizerItems.addAppetizer(new Appetizer("양송이수프", 6000));
        appetizerItems.addAppetizer(new Appetizer("타파스", 5500));
        appetizerItems.addAppetizer(new Appetizer("시저샐러드", 8000));
    }

    private boolean isInProgress() {
        return serviceStatus == ServiceStatus.IN_PROGRESS;
    }

}
