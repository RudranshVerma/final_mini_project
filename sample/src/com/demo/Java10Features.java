package com.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Java10Features {

    public static void run() {
        localVariableTypeInference();
    }

    private static void localVariableTypeInference() {
        System.out.println("Local Variable Type Inference (`var`) demo");

        var list = List.of(1, 2, 3, 4, 5);
        var sum = list.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum of list: " + sum);
    }
}