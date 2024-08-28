package com.demo;

import java.util.List;

public class Java16Features {

    public static void run() {
        recordsStandard();
        patternMatchingInstanceOfStandard();
    }

    private static void recordsStandard() {
        System.out.println("Records Standard demo");

        Employee emp = new Employee("John Doe", List.of("Developer", "Designer"));
        System.out.println("Employee: " + emp);
    }

    record Employee(String name, List<String> roles) {}
    
    private static void patternMatchingInstanceOfStandard() {
        System.out.println("Pattern Matching for `instanceof` Standard demo");

        Object obj = 123;
        if (obj instanceof Integer number) {
            System.out.println("Number: " + number);
        }
    }
}