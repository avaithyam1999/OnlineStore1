package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Welcome to Ajith's Online Store
                Select an Option:
                1. Display all products available
                2. Display Items in Cart
                3. Exit out of store
                """);
        int userChoice = scanner.nextInt();
        scanner.nextLine();

        boolean mainRunning = true;
        while (mainRunning) {
            switch (userChoice) {
                case 1 -> {
//                    displayAllItems();
                    BufferedReader buffReader = new BufferedReader(new FileReader("products.csv"));

                }
                case 2 -> {
//                    displayCartItems();
                }
                case 3 -> {
                    mainRunning = false;
                }
                default -> {
                    System.out.println("You entered an invalid number");
                }
            }
        }

    }
}
