package org.example;

import java.util.Objects;

abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    protected double price;


    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void sell();

    public String getDetails() {
        return String.format("%s %s (%d) - $%d", brand, model, year, (int) price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) obj;
        return year == vehicle.year &&
                Double.compare(vehicle.price, price) == 0 &&
                brand.equals(vehicle.brand) &&
                model.equals(vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, price);
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}