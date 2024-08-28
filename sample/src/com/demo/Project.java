package com.demo;

import java.util.Scanner;

public class Project {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Java Feature Demo Application");
			System.out.println("Select a Java version to explore features:");
			System.out.println("1. Java 8");
			System.out.println("2. Java 9");
			System.out.println("3. Java 10");
			System.out.println("4. Java 11");
			System.out.println("5. Java 12");
			System.out.println("6. Java 13");
			System.out.println("7. Java 14");
			System.out.println("8. Java 15");
			System.out.println("9. Java 16");
			System.out.println("10. Java 17");
			System.out.println("0. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1 -> Java8Features.run();
			case 2 -> Java9Features.run();
			case 3 -> Java10Features.run();
			case 4 -> Java11Features.run();
			case 5 -> Java12Features.run();
			case 6 -> Java13Features.run();
			case 7 -> Java14Features.run();
			case 8 -> Java15Features.run();
			case 9 -> Java16Features.run();
			case 10 -> Java17Features.run();
			case 0 -> {
				System.out.println("Exiting...");
				return;
			}
			default -> System.out.println("Invalid choice. Please select a valid option.");
			}
		}
	}
}
