package com.pluralsight;

public class Program {
    public static void main(String[] args) {

        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership("src/main/resources/inventory.csv");


    }
}
