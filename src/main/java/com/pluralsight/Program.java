package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        boolean programRunning = true;
        while (programRunning) {
            System.out.println("""
                Welcome to Ajith's Online Store
                Select an Option:
                1. Display all products available
                2. Display Items in Cart
                3. Exit out of store
                """);
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> {
//                   displayAllItems();
                    printAllProducts(inventory);
                }
                case 2 -> {
//                   displayCartItems();
                }
                case 3 -> {
                    System.out.println("Thanks for using the app, goodbye");
                    programRunning = false;
                }
                default -> {
                    System.out.println("You entered an invalid number");
                }
            }

        }
    }


    private static void printAllProducts(ArrayList<Product> inventory) throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("products.csv"));
        buffReader.readLine();
        String line;
        while ((line = buffReader.readLine()) != null) {
            Product product = parseProduct(line);
            if (product != null) {
                inventory.add(product);
            }
        }
        for (Product product : inventory) {
            System.out.println(product);
        }
        buffReader.close();
    }

    private static Product parseProduct(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 4) {
            String sku = parts[0];
            String productName = parts[1];
            double price = Double.parseDouble(parts[2]);
            String department = parts[3];

            return new Product(sku, productName, price, department);
        } else {
            System.out.println("Invalid");
        }
        return null;
    }
}
