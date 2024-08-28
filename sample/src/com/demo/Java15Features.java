package com.demo;

public class Java15Features {

    public static void run() {
        textBlocksStandard();
        sealedClasses();
    }

    private static void textBlocksStandard() {
        System.out.println("Text Blocks Standard demo");

        String json = """
                {
                    "name": "John",
                    "age": 30
                }
                """;

        System.out.println("JSON Content:\n" + json);
    }

    private static void sealedClasses() {
        System.out.println("Sealed Classes demo");

        Shape shape = new Circle(5);
        System.out.println("Shape Area: " + shape.area());
    }

    sealed interface Shape {
        double area();
    }

    record Circle(double radius) implements Shape {
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    record Square(double side) implements Shape {
        public double area() {
            return side * side;
        }
    }
}