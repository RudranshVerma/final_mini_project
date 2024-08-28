package com.demo;

public class Java14Features {

    public static void run() {
        patternMatchingInstanceOf();
        recordDemo();
    }

    private static void patternMatchingInstanceOf() {
        System.out.println("Pattern Matching for `instanceof` demo");

        Object obj = "Hello, Java 14!";
        if (obj instanceof String str) {
            System.out.println("String length: " + str.length());
        }
    }

    private static void recordDemo() {
        System.out.println("Records demo");

        Person person = new Person("Alice", 30);
        System.out.println("Person: " + person);
    }

    record Person(String name, int age) {}
}