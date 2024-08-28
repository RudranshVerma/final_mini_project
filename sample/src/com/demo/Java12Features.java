package com.demo;

public class Java12Features {

    public static void run() {
        switchExpressions();
    }

    private static void switchExpressions() {
        System.out.println("Switch Expressions demo");

        int day = 2;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };

        System.out.println("Day type: " + dayType);
    }
}