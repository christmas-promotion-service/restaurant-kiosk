package org.example.restaurantkiosk.restaurant.menu;

public class MenuInitializer {
    public MenuItems initializeMenu() {
        MenuItems menuItems = new MenuItems();
        initializeAppetizers(menuItems);
        initializeMainCourses(menuItems);
        initializeDesserts(menuItems);
        initializeDrinks(menuItems);
        return menuItems;
    }

    private void initializeAppetizers(MenuItems menuItems) {
        menuItems.addItem(new Appetizer("양송이수프", 6000));
        menuItems.addItem(new Appetizer("타파스", 5500));
        menuItems.addItem(new Appetizer("시저샐러드", 8000));
    }

    private void initializeMainCourses(MenuItems menuItems) {
        menuItems.addItem(new MainCourse("티본스테이크", 55000));
        menuItems.addItem(new MainCourse("바비큐립", 54000));
        menuItems.addItem(new MainCourse("해산물파스타", 35000));
        menuItems.addItem(new MainCourse("크리스마스파스타", 25000));
    }

    private void initializeDesserts(MenuItems menuItems) {
        menuItems.addItem(new Dessert("초코케이크", 15000));
        menuItems.addItem(new Dessert("아이스크림", 5000));
    }

    private void initializeDrinks(MenuItems menuItems) {
        menuItems.addItem(new Drink("제로콜라", 3000));
        menuItems.addItem(new Drink("레드와인", 60000));
        menuItems.addItem(new Drink("샴페인", 25000));
    }
}
