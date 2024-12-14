package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Garage garage;
    private static SalesEmployee salesEmployee;
    private static Showroom showroom;
    private static Client client1;
    private static Client client2;

    public static void main(String[] args) {
        initializeData();
        boolean running = true;

        while (running) {
            running = displayMenu();
        }

        scanner.close();
    }

    public static void initializeData() {
        garage = new Garage("Downtown");
        salesEmployee = new SalesEmployee("Alice");
        showroom = new Showroom(garage, salesEmployee);

        // Добавляем автомобили
        garage.addVehicle(new Sedan("Toyota", "Camry", 2020, 24000));
        garage.addVehicle(new SUV("Ford", "Explorer", 2021, 32000));
        garage.addVehicle(new Motorcycle("Harley-Davidson", "Street", 2022, 15000));

        // Добавляем клиентов
        client1 = new Client("John Doe", "johndoe@example.com");
        client2 = new Client("Jane Smith", "janesmith@example.com");
    }

    public static boolean displayMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1. Посмотреть информацию о машинах");
        System.out.println("2. Посмотреть информацию о клиентах");
        System.out.println("3. Посмотреть информацию о работниках");
        System.out.println("4. Продать машину");
        System.out.println("0. Выход");

        try {
            int choice = getInput();
            switch (choice) {
                case 1:
                    showVehicles();
                    break;
                case 2:
                    showClients();
                    break;
                case 3:
                    showEmployees();
                    break;
                case 4:
                    sellVehicle();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return false;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введите целое число.");
            scanner.next(); // Очистка неверного ввода
        }
        return true;
    }

    public static int getInput() {
        return scanner.nextInt();
    }

    public static void showVehicles() {
        System.out.println("\nИнформация о машинах:");
        for (Vehicle vehicle : garage.getVehicles()) {
            if (vehicle != null) {
                System.out.println(vehicle.getBrand() + " " + vehicle.getModel() +
                        " (" + vehicle.getYear() + ") - $" + vehicle.getPrice());
            }
        }
    }

    public static void showClients() {
        System.out.println("\nИнформация о клиентах:");
        System.out.println(client1.getName() + " - " + client1.getContactInfo());
        System.out.println(client2.getName() + " - " + client2.getContactInfo());
    }

    public static void showEmployees() {
        System.out.println("\nИнформация о работниках:");
        System.out.println(salesEmployee.getName() + " - " + salesEmployee.getPosition());
    }

    public static void sellVehicle() {
        System.out.println("\nПродажа машины:");
        System.out.println("Какую машину хотите продать?");
        for (Vehicle vehicle : garage.getVehicles()) {
            if (vehicle != null) {
                System.out.println(vehicle.getBrand() + " " + vehicle.getModel());
            }
        }
        String vehicleToSell = getVehicleInput();
        boolean found = false;

        for (Vehicle vehicle : garage.getVehicles()) {
            if (vehicle != null && vehicle.getModel().equalsIgnoreCase(vehicleToSell)) {
                System.out.println("Поздравляем с приобретением " + vehicle.getDetails() + "!");

                // Создаем квитанцию
                PurchaseReceipt receipt = new PurchaseReceipt(vehicle, client1, vehicle.getPrice());
                receipt.printReceipt();

                // Удаляем автомобиль из гаража (если необходимо)
                garage.removeVehicle(vehicle);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Машина не найдена.");
        }
    }

    public static String getVehicleInput() {
        return scanner.next();
    }
}