package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static Scanner scanner = new Scanner(System.in);
    public static Dealership dealership;

    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership("src/main/resources/inventory.csv");

        int choice = 0;
        do {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Option 1: Find vehicles within a price range");
                    try {
                        System.out.print("Enter minimum price: ");
                        double minPrice = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter maximum price: ");
                        double maxPrice = Double.parseDouble(scanner.nextLine());
                        List<Vehicle> vehiclesInRange = dealership.getVehiclesByPrice(minPrice, maxPrice);
                        if (vehiclesInRange == null || vehiclesInRange.isEmpty()) {
                            System.out.println("No vehicles found in this price range.");
                        } else {
                            for (Vehicle vehicle : vehiclesInRange) {
                                System.out.println(vehicle);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a valid number for price.");
                    }
                    break;
                case 2:
                    System.out.println("Option 2: Find vehicles by make / model");
                    break;
                case 3:
                    System.out.println("Option 3: Find vehicles by year range");
                    break;
                case 4:
                    System.out.println("Option 4: Find vehicles by color");
                    break;
                case 5:
                    System.out.println("Option 5: Find vehicles by mileage range");
                    break;
                case 6:
                    System.out.println("Option 6: Find vehicles by type");
                    break;
                case 7:
                    System.out.println("Option 7: List ALL vehicles");
                    List<Vehicle> allVehicles = dealership.getAllVehicles();
                    if (allVehicles.isEmpty()) {
                        System.out.println("No vehicles found in inventory.");
                    } else {
                        for (Vehicle vehicle : allVehicles) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case 8:
                    System.out.println("Option 8: Add a vehicle");
                    addVehicleProcess();
                    break;
                case 9:
                    System.out.println("Option 9: Remove a vehicle");
                    break;
                case 99:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
                    break;
            }
        } while (choice != 99);
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

    private static void addVehicleProcess() {
        System.out.print("Enter VIN number: ");
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter type of car: ");
        String type = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter mileage: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        System.out.println("\n-----Vehicle added to inventory!-----");

    }
}