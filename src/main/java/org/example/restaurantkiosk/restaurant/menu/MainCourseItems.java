package org.example.restaurantkiosk.restaurant.menu;

import java.util.ArrayList;
import java.util.List;

public class MainCourseItems {
    // 메뉴 열람 및 확장에 용이하도록 일급컬렉션으로 추상화함.
    private final List<MainCourse> mainCourses = new ArrayList<>();

    public void addMainCourse(MainCourse mainCourse) {
        mainCourses.add(mainCourse);
    }

    public void displayMainCourses() {
        System.out.println("\n<메인>");
        for (MainCourse mainCourse : mainCourses) {
            System.out.println(mainCourse);
        }
    }
}