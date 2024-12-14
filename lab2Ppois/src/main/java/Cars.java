package org.example;
class Cars extends Vehicle {
    private String fuelType;

    public Cars(String brand, String model, int year, double price, String fuelType) {
        super(brand, model, year, price);
        this.fuelType = fuelType;
    }

    @Override
    public void sell() {
        System.out.println("Selling car: " + getDetails());
    }

    // Геттер и сеттер для fuelType
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}