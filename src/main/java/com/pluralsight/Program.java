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
        ArrayList<Product> inventory = loadAllProducts();
        ArrayList<Product> cart = new ArrayList<>();

        boolean programRunning = true;
        while (programRunning) {
            System.out.println("""
                Welcome to Ajith's Online Store
                Select an Option:
                1. Display Products
                2. Display Items in Cart
                3. Exit out of store
                """);
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> {
                    boolean displayMenuRunning = true;
                    while (displayMenuRunning) {
                        System.out.println("""
                                Select an Option:
                                1. Search for a product
                                2. Add a product to cart
                                3. Go back to Store Menu
                                """);
                        int userDisplayChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (userDisplayChoice) {
                            case 1 -> {
                                //printSearchProduct();
                                System.out.println("Enter search keyword");
                                String searchKeyWord = scanner.nextLine().trim().toLowerCase();

                                ArrayList<Product> results = new ArrayList<>();
                                for (Product product : inventory) {
                                    if (product.getProductName().trim().toLowerCase().contains(searchKeyWord)) {
                                        results.add(product);
                                    }
                                }
                                printProducts(results);
                            }
                            case 2 -> {
                                //addToCart();
                                System.out.println("Enter the SKU of the product you want to add to your cart");
                                String searchSKUItem = scanner.nextLine().trim().toUpperCase();

                                Product item = null;
                                for (Product product : inventory) {
                                    if (product.getSku().trim().toUpperCase().contains(searchSKUItem)) {
                                        item = product;
                                    }
                                }

                                if (item != null) {
                                    cart.add(item);
                                    System.out.printf("%s has been added to your cart\n", item.getProductName());
                                } else {
                                    System.out.printf("Nothing was found for %s\n", searchSKUItem);
                                }


                            }
                            case 3 -> {
                                displayMenuRunning = false;
                            }
                        }
                    }
                }
                case 2 -> {
//                   displayCartItems();
                    if (cart.isEmpty()) {
                        System.out.println("The cart is empty");
                    } else {
                        System.out.printf("You have %d item(s) in your cart\n", cart.size());
                        for (Product item : cart) {
                            System.out.println(item);
                        }

                        double total = 0;
                        for (Product item : cart) {
                            total = total + item.getPrice();
                        }
                        System.out.printf("Cart Total: $%.2f\n", total);
                    }
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


    private static ArrayList<Product> loadAllProducts() throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        BufferedReader buffReader = new BufferedReader(new FileReader("products.csv"));
        buffReader.readLine();
        String line;
        while ((line = buffReader.readLine()) != null) {
            Product product = parseProduct(line);
            if (product != null) {
                products.add(product);
            }
        }
        return products;
    }

    private static void printProducts(ArrayList<Product> products) throws IOException {
        if (products.isEmpty()) {
            System.out.println("No Products found");
        } else {
            System.out.printf("%d Result(s) found:\n", products.size());
            for (Product product : products) {
                System.out.println(product);
            }
        }
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
