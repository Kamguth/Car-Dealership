package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();

        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership("src/main/resources/inventory.csv");
    }

    private static void displayMenu() {
        System.out.println("\n1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter choice: ");
    }
}
