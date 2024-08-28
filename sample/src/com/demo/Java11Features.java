package com.demo;

public class Java11Features {

    public static void run() {
        newStringMethods();
        lambdaParameterVar();
    }

    private static void newStringMethods() {
        System.out.println("New String Methods demo");
        String str = " ";
        System.out.println("Is blank: " + str.isBlank());
        System.out.println("Repeat string: " + "Java ".repeat(3));
    }

    private static void lambdaParameterVar() {
        System.out.println("Lambda Parameter var Syntax demo");
        varOperation((var x, var y) -> x + y);
    }

    private static void varOperation(Operation op) {
        System.out.println("Operation result: " + op.execute(3, 5));
    }

    interface Operation {
        int execute(int a, int b);
    }
}