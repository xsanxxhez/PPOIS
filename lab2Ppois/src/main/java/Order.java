package org.example;

class Order {
    private Client client;
    private Vehicle vehicle;

    public Order(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
    }

    public void processOrder() {
        System.out.println("Processing order for " + client.getName() + " for vehicle: " + vehicle.getDetails());
    }

    // Геттеры и сеттеры
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}