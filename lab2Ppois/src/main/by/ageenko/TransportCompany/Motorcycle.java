package org.example;

class Motorcycle extends Vehicle {
    public Motorcycle(String brand, String model, int year, double price) {
        super(brand, model, year, price);
    }

    @Override
    public void sell() {
        System.out.println("Selling motorcycle: " + getDetails());
    }
}

