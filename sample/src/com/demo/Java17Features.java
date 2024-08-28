package com.demo;

public class Java17Features {

    public static void run() {
        sealedClassesStandard();
//        patternMatchingForSwitch();
    }

    private static void sealedClassesStandard() {
        System.out.println("Sealed Classes Standard demo");

        Animal animal = new Dog("Buddy");
        System.out.println("Animal Sound: " + animal.sound());
    }

    sealed interface Animal permits Dog, Cat {
        String sound();
    }

    record Dog(String name) implements Animal {
        public String sound() {
            return "Woof!";
        }
    }

    record Cat(String name) implements Animal {
        public String sound() {
            return "Meow!";
        }
    }
//
//    private static void patternMatchingForSwitch() {
//        System.out.println("Pattern Matching for Switch demo");
//
//        Object obj = 42;
//        String result = switch (obj) {
//            case Integer i -> "Integer: " + i;
//            case String s -> "String: " + s;
//            default -> "Unknown type";
//        };
//
//        System.out.println("Result: " + result);
//    }
}