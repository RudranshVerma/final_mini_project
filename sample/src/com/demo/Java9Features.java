package com.demo;

import java.util.List;

public class Java9Features {

    public static void run() {
        privateInterfaceMethods();
        tryWithResourcesEnhancement();
        factoryMethodsForCollections();
    }

    private static void privateInterfaceMethods() {
        System.out.println("Private interface methods demo");
        MyInterface instance = new MyInterface() {};
        instance.publicMethod();
    }

    interface MyInterface {
        private void privateMethod() {
            System.out.println("Private method in interface");
        }

        default void publicMethod() {
            privateMethod();
            System.out.println("This is a public method in an interface");
        }
    }

    private static void tryWithResourcesEnhancement() {
        System.out.println("Try-with-resources enhancement demo");
        MyResource resource = new MyResource();
        try (resource) {
            resource.doSomething();
        }
    }

    static class MyResource implements AutoCloseable {
        void doSomething() {
            System.out.println("Doing something...");
        }

        @Override
        public void close() {
            System.out.println("Closing resource...");
        }
    }

    private static void factoryMethodsForCollections() {
        System.out.println("Factory methods for Collections demo");
        List<String> list = List.of("A", "B", "C");
        System.out.println("Immutable List: " + list);
    }
}