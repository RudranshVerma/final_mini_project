package com.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Features {

    public static void run() {
        lambdaExpressions();
        streamApi();
        optionalExample();
        dateTimeApi();
        defaultMethod();
    }

    private static void lambdaExpressions() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println("Hello, " + name));
    }

    private static void streamApi() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squared = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());
        System.out.println("Squared Numbers: " + squared);
    }

    private static void optionalExample() {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println("Name is present: " + name.isPresent());
        name.ifPresentOrElse(System.out::println, () -> System.out.println("Name is absent"));
    }

    private static void dateTimeApi() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today.format(DateTimeFormatter.ISO_DATE));
    }

    interface MyInterface {
        default void defaultMethod() {
            System.out.println("This is a default method in an interface");
        }
    }

    private static void defaultMethod() {
        MyInterface instance = new MyInterface() {};
        instance.defaultMethod();
    }
}