package org.example;

class Garage {
    private String location;
    private Vehicle[] vehicles;
    private int vehicleCount;

    public Garage(String location) {
        this.location = location;
        this.vehicles = new Vehicle[10]; // Максимум 10 автомобилей
        this.vehicleCount = 0;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicleCount < vehicles.length) {
            vehicles[vehicleCount++] = vehicle;
            System.out.println("Vehicle added to garage: " + vehicle.getDetails());
        } else {
            System.out.println("Garage is full!");
        }
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].equals(vehicle)) { // Предполагаем, что метод equals() переопределён в классе Vehicle
                vehicles[i] = vehicles[vehicleCount - 1]; // Замена удаляемого элемента последним
                vehicles[vehicleCount - 1] = null; // Обнуление последнего элемента
                vehicleCount--;
                System.out.println("Vehicle removed from garage: " + vehicle.getDetails());
                return true;
            }
        }
        System.out.println("Vehicle not found in garage.");
        return false;
    }

    public boolean contains(Vehicle vehicle) {
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].equals(vehicle)) { // Проверка на равенство
                return true;
            }
        }
        return false;
    }
    public int size() {
        return vehicleCount; // Возвращаем текущее количество транспортных средств
    }
    // Геттеры и сеттеры
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }
    public Vehicle getVehicleByModel(String model) {
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getModel().equalsIgnoreCase(model)) {
                return vehicles[i]; // Возвращаем первое совпадение
            }
        }
        return null; // Если транспортное средство не найдено, возвращаем null
    }
}