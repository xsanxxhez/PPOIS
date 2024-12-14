package org.example;

class PurchaseReceipt {
    private Vehicle vehicle;
    private Client client;
    private double amount;

    public PurchaseReceipt(Vehicle vehicle, Client client, double amount) {
        this.vehicle = vehicle;
        this.client = client;
        this.amount = amount;
    }

    public void printReceipt() {
        System.out.println("Receipt:");
        System.out.println("Client: " + client.getName());
        System.out.println("Vehicle: " + vehicle.getDetails());
        System.out.println("Amount: $" + amount);
    }

    // Геттеры и сеттеры
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
