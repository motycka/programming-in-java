package com.motycka.java.practice.lesson2.enums;

public class EnumExample {
    public static void main(String[] args) {
        System.out.println(getHoursInClass(Days.WEDNESDAY)); // prints 3
    }

    private static int getHoursInClass(Days day) {
        switch (day) {
            case MONDAY, TUESDAY, THURSDAY -> {
                return 4;
            }
            case WEDNESDAY, FRIDAY -> {
                return 3;
            }
            case SATURDAY, SUNDAY -> {
                return 1;
            }
            default -> {
                return 0;
            }
        }
    }
}


enum Days {
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(false),
    SUNDAY(false);

    private final boolean isWorkDay;

    Days(boolean isWorkDay) {
        this.isWorkDay = isWorkDay;
    }

    public boolean isWorkDay() {
        return isWorkDay;
    }
}
